package com.example.pokedexapp.domain.usecase

import android.util.Log
import arrow.core.Either
import com.example.pokedexapp.data.repository.Repository
import com.example.pokedexapp.util.POKEMON_LIMIT
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() {
        val response = repository.getAllPokemons(POKEMON_LIMIT)
         response.collect {
             when(it){
                 is Either.Left -> {}
                 is Either.Right -> {
                     for (name in it.value){
                         Log.d("Leo", "Pokemon: ${it.value}")
                     }
                 }
             }
         }
    }
}