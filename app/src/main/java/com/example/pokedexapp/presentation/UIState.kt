package com.example.pokedexapp.presentation

import com.example.pokedexapp.domain.model.PokemonDto

sealed interface UIState {
    data class Success(val data: List<PokemonDto>) : UIState
    data object Loading : UIState
    data class Error(val message: String) : UIState
    data object Idle : UIState
}