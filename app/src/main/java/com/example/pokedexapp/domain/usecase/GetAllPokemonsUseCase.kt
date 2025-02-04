package com.example.pokedexapp.domain.usecase

import android.util.Log
import com.example.pokedexapp.domain.repository.Repository
import com.example.pokedexapp.util.POKEMON_LIMIT
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() {
        val response = repository.getAllPokemons(POKEMON_LIMIT)

        for (name in response.results){
            Log.d("Leo", "Pokemon: $name")
        }
    }
}