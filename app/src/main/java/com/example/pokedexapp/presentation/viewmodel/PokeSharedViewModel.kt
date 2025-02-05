package com.example.pokedexapp.presentation.viewmodel

import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.pokedexapp.domain.model.PokemonDto
import com.example.pokedexapp.domain.usecase.GetAllPokemonsFromDBUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetPokemonInfoUseCase
import com.example.pokedexapp.domain.usecase.InsertListOfPokemonsUseCase
import com.example.pokedexapp.domain.usecase.SearchPokemonUseCase
import com.example.pokedexapp.presentation.states.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeSharedViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase,
    private val getAllPokemonsFromDBUseCase: GetAllPokemonsFromDBUseCase,
    private val insertListOfPokemonsUseCase: InsertListOfPokemonsUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase,
    private val connectivity: ConnectivityManager,
) : ViewModel() {
    private val pokemonList = arrayListOf<PokemonDto>()
    private val _connectionStatus = MutableStateFlow(false)
    private val connectionStatus = _connectionStatus.asStateFlow()
    private val _uiState = MutableStateFlow<UIState>(UIState.Idle)
    val uiState = _uiState.asStateFlow()

    private fun getAllPokemons() {
        viewModelScope.launch {
            val response = getAllPokemonsUseCase.invoke()
            response.collect {
                when (it) {
                    is Either.Left -> {
                        _uiState.value = UIState.Error.Exception
                    }
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

    fun checkConnection() {
        connectivity.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback(){
            override fun onLost(network: Network) {
                super.onLost(network)
                _connectionStatus.value = false
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                _connectionStatus.value = true
            }
        })
    }

    fun getSelectedPokemon(id: Int) = pokemonList.filter { it.id == id }[0]

    fun searchPokemon(name: String) {
        viewModelScope.launch {
            val query = searchPokemonUseCase.invoke(name)
            query.collect {
                if (it.isEmpty()) {
                    _uiState.value = UIState.Error.UnknownPokemon
                } else {
                    _uiState.value = UIState.Success(it)
                }
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
                    if (connectionStatus.value) {
                        _uiState.value = UIState.Loading
                        getAllPokemons()
                    } else {
                        _uiState.value = UIState.Error.NoInternetConnection
                    }
                } else {
                    pokemonList.addAll(it)
                    _uiState.value = UIState.Success(pokemonList)
                }
            }
        }
    }

    private suspend fun getPokemonInfo(id: Int) {
        val response = getPokemonInfoUseCase.invoke(id)
        response.collect {
            when (it) {
                is Either.Left -> {
                    _uiState.value = UIState.Error.Exception
                }
                is Either.Right -> {
                    pokemonList.add(it.value)
                }
            }
        }
    }

    private fun getId(url: String) =
        url.reversed().substring(1, 5).substringBefore("/").reversed().toInt()

}