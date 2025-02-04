package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.datasource.ApiSource

class RepositoryImp(private val apiSource: ApiSource) : Repository {

    override suspend fun getAllPokemons(limit: Int) = apiSource.getAllPokemons(limit)

    override suspend fun getOnePokemn(id: Int) = apiSource.getOnePokemn(id)
}