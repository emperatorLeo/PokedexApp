package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.remote.PokeService
import com.example.pokedexapp.domain.datasource.ApiSource

class ApiSourceImp(private val pokeService: PokeService) : ApiSource {
    override suspend fun getAllPokemons(limit: Int) =
        pokeService.getAllPokemons(limit)

    override suspend fun getOnePokemn(id: Int) = pokeService.getOnePokemon(id)
}