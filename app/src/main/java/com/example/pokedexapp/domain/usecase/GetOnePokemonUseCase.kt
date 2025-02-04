package com.example.pokedexapp.domain.usecase

import android.util.Log
import com.example.pokedexapp.domain.repository.Repository
import javax.inject.Inject

class GetOnePokemonUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(pokemonId: Int) {
        val response = repository.getOnePokemn(pokemonId)
        Log.d("Leo", "Single pokemon: $response")
    }
}