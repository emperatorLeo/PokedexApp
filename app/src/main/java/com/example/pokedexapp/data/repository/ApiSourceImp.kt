package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.remote.PokeService
import com.example.pokedexapp.domain.datasource.ApiSource
import javax.inject.Inject

class ApiSourceImp @Inject constructor(private val pokeService: PokeService): ApiSource {
    override suspend fun getAllPokemons(limit: Int) =
        pokeService.getAllPokemons(limit)

}