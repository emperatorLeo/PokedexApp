package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.model.entities.Pokemon
import com.example.pokedexapp.data.repository.Repository
import javax.inject.Inject

class InsertListOfPokemonsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(list: List<Pokemon>) {
        repository.insertListPokemon(list)
    }
}