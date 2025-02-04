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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    init {
        getAllPokemons()
    }

    fun getAllPokemons() {
        viewModelScope.launch {
            delay(5000)
            val response = getAllPokemonsUseCase.invoke()
            response.collect {
                when (it) {
                    is Either.Left -> {}
                    is Either.Right -> {
                        for (pokedex in it.value) {
                            getOnePokemon(getId(pokedex.url))
                            if (pokemonList.size >= 151)
                                Log.d("Leo", "pokemonList $pokemonList")
                        }
                    }
                }
            }
        }
    }

    private suspend fun getOnePokemon(id: Int) {
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

    private fun getId(url: String) =
        url.reversed().substring(1, 5).substringBefore("/").reversed().toInt()

}