package com.example.pokedexapp.data.repository

import com.example.pokedexapp.domain.datasource.ApiSource
import com.example.pokedexapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiSource: ApiSource) : Repository {
    override suspend fun goCatchThemAll(limit: Int) = apiSource.getAllPokemons(limit)
}