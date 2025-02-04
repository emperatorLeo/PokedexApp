package com.example.pokedexapp.domain.usecase

import android.util.Log
import arrow.core.Either
import com.example.pokedexapp.data.repository.Repository
import javax.inject.Inject

class GetOnePokemonUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(pokemonId: Int) {
        val response = repository.getOnePokemn(pokemonId)
        response.collect {
            when (it) {
                is Either.Left -> {}
                is Either.Right -> {
                    Log.d("Leo", "Single pokemon: ${it.value.name}")
                }
            }
        }
    }
}