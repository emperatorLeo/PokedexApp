package com.example.pokedexapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.domain.usecase.EmptyTableUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsFromDBUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetOnePokemonUseCase
import com.example.pokedexapp.domain.usecase.InsertListOfPokemonsUseCase
import com.example.pokedexapp.domain.usecase.SearchPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        getAllPokemons()
    }

    fun getAllPokemons() {
        Log.d("Leo", "launching a coroutine")
        viewModelScope.launch {
            getAllPokemonsUseCase.invoke()
            getOnePokemon()
        }
    }

    private suspend fun getOnePokemon() {
        getOnePokemonUseCase.invoke(7)
    }
}