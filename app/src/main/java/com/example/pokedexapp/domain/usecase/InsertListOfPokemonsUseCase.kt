package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.repository.Repository
import com.example.pokedexapp.domain.model.PokemonDto
import javax.inject.Inject

class InsertListOfPokemonsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(list: List<PokemonDto>) {
        repository.insertListPokemon(list)
    }
}