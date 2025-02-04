package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.repository.Repository
import javax.inject.Inject

class GetOnePokemonUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(pokemonId: Int) = repository.getOnePokemon(pokemonId)

}