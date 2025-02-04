package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.localdatasource.LocalDataSource
import com.example.pokedexapp.data.remotedatasource.ApiSource
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow

class RepositoryImp(
    private val apiSource: ApiSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getAllPokemons(limit: Int) = apiSource.getAllPokemons(limit)

    override suspend fun getOnePokemon(id: Int) = apiSource.getOnePokemon(id)

    override suspend fun insertListPokemon(pokemonList: List<PokemonDto>) {
      val mappedList = pokemonList.map { it.fromDtoToEntity() }
      return  localDataSource.insertListPokemon(mappedList)
    }

    override suspend fun getAllPokemonsFromDB(): Flow<List<PokemonDto>> =
        localDataSource.getAllPokemonsFromDB()

    override suspend fun searchPokemon(name: String): Flow<List<PokemonDto>> =
        localDataSource.searchPokemon(name)
}
