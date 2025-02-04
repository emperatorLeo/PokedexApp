package com.example.pokedexapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.pokedexapp.domain.model.PokemonDto
import com.example.pokedexapp.domain.usecase.EmptyTableUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsFromDBUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetOnePokemonUseCase
import com.example.pokedexapp.domain.usecase.InsertListOfPokemonsUseCase
import com.example.pokedexapp.domain.usecase.SearchPokemonUseCase
import com.example.pokedexapp.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeSharedViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val getOnePokemonUseCase: GetOnePokemonUseCase,
    private val getAllPokemonsFromDBUseCase: GetAllPokemonsFromDBUseCase,
    private val insertListOfPokemonsUseCase: InsertListOfPokemonsUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase,
    private val emptyTableUseCase: EmptyTableUseCase,
) : ViewModel() {
    private val pokemonList = arrayListOf<PokemonDto>()
    private val _uiState = MutableStateFlow<UIState>(UIState.Idle)
    val uiState = _uiState.asStateFlow()

    private fun getAllPokemons() {
        viewModelScope.launch {
            val response = getAllPokemonsUseCase.invoke()
            response.collect {
                when (it) {
                    is Either.Left -> {}
                    is Either.Right -> {
                        for (pokedex in it.value) {
                            getPokemonInfo(getId(pokedex.url))
                            if (pokemonList.size >= 151)
                                savePokemons(pokemonList)
                        }
                    }
                }
            }
        }
    }

    private fun searchPokemon(name: String) {
        viewModelScope.launch {
            val query = searchPokemonUseCase.invoke(name)
            query.collect {
                Log.d("Leo", "db search List: $it")
            }
        }
    }

    private fun savePokemons(list: List<PokemonDto>) {
        viewModelScope.launch {
            insertListOfPokemonsUseCase.invoke(list)
            getAllDBPokemons()
        }
    }

    fun getAllDBPokemons() {
        viewModelScope.launch {
            val query = getAllPokemonsFromDBUseCase.invoke()
            query.collect {
                if (it.isEmpty()) {
                    _uiState.value = UIState.Loading
                    getAllPokemons()
                } else {
                    _uiState.value = UIState.Success(it)
                }
            }
        }
    }

    private suspend fun getPokemonInfo(id: Int) {
        val response = getOnePokemonUseCase.invoke(id)
        response.collect {
            when (it) {
                is Either.Left -> {}
                is Either.Right -> {
                    pokemonList.add(it.value)
                }
            }
        }
    }

    private fun dropTable() {
        viewModelScope.launch {
            emptyTableUseCase.invoke()
        }
    }

    private fun getId(url: String) =
        url.reversed().substring(1, 5).substringBefore("/").reversed().toInt()

}