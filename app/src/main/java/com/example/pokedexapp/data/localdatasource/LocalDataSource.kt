package com.example.pokedexapp.data.localdatasource

import com.example.pokedexapp.data.model.entities.Pokemon
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertSinglePokemon(pokemon: Pokemon)

    suspend fun insertListPokemon(pokemonList: List<Pokemon>)

    suspend fun getAllPokemonsFromDB(): Flow<List<PokemonDto>>

    suspend fun searchPokemon(name: String): Flow<List<PokemonDto>>

    suspend fun emptyTable()
}