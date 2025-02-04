package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.repository.Repository
import javax.inject.Inject

class SearchPokemonUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(pokemonName: String) = repository.searchPokemon(pokemonName)

}