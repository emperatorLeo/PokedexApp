package com.example.pokedexapp.presentation.states

import com.example.pokedexapp.domain.model.PokemonDto

sealed class UIState {
    data class Success(val data: List<PokemonDto>) : UIState()
    data object Loading : UIState()
    sealed class Error : UIState() {
        data object NoInternetConnection : UIState()
        data object UnknownPokemon: UIState()
        data object Exception: UIState()
    }
    data object Idle : UIState()
}