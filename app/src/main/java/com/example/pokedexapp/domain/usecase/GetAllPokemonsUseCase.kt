package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.repository.Repository
import com.example.pokedexapp.common.POKEMON_LIMIT
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getAllPokemons(POKEMON_LIMIT)

}