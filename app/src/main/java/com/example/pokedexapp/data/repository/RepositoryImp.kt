package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.localdatasource.LocalDataSource
import com.example.pokedexapp.data.model.entities.Pokemon
import com.example.pokedexapp.data.remotedatasource.ApiSource

class RepositoryImp(
    private val apiSource: ApiSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getAllPokemons(limit: Int) = apiSource.getAllPokemons(limit)

    override suspend fun getOnePokemon(id: Int) = apiSource.getOnePokemon(id)

    override suspend fun insertSinglePokemon(pokemon: Pokemon) =
        localDataSource.insertSinglePokemon(pokemon)


    override suspend fun insertListPokemon(pokemonList: List<Pokemon>) =
        localDataSource.insertListPokemon(pokemonList)


    override suspend fun getAllPokemonsFromDB(): List<Pokemon> =
        localDataSource.getAllPokemonsFromDB()


    override suspend fun searchPokemon(name: String): List<Pokemon> =
        localDataSource.searchPokemon(name)

    override suspend fun emptyTable() = localDataSource.emptyTable()
}