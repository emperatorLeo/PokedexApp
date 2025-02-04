package com.example.pokedexapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetOnePokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeSharedViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
    private val getOnePokemonUseCase: GetOnePokemonUseCase,
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