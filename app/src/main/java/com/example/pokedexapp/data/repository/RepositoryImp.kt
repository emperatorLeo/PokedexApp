package com.example.pokedexapp.data.repository

import com.example.pokedexapp.domain.datasource.ApiSource
import com.example.pokedexapp.domain.repository.Repository

class RepositoryImp(private val apiSource: ApiSource) : Repository {
    override suspend fun getAllPokemons(limit: Int) = apiSource.getAllPokemons(limit)

    override suspend fun getOnePokemn(id: Int) = apiSource.getOnePokemn(id)
}