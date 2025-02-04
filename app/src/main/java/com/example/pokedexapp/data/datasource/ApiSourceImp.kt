package com.example.pokedexapp.data.datasource

import com.example.pokedexapp.data.remote.PokeService

class ApiSourceImp(private val pokeService: PokeService) : ApiSource {
    override suspend fun getAllPokemons(limit: Int) =
        pokeService.getAllPokemons(limit)

    override suspend fun getOnePokemn(id: Int) = pokeService.getOnePokemon(id)
}