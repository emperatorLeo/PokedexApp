package com.example.pokedexapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeSharedViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase
): ViewModel() {

    init {
        getAllPokemons()
    }

    fun getAllPokemons(){
        Log.d("Leo","launching a coroutine")
        viewModelScope.launch {
            delay(5000)
            getAllPokemonsUseCase.invoke()
        }
    }
}