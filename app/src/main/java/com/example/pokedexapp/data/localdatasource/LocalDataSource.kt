package com.example.pokedexapp.data.localdatasource

import com.example.pokedexapp.data.model.entities.Pokemon

interface LocalDataSource {

    suspend fun insertSinglePokemon(pokemon: Pokemon)

    suspend fun insertListPokemon(pokemonList: List<Pokemon>)

    suspend fun getAllPokemonsFromDB(): List<Pokemon>

    suspend fun searchPokemon(name: String): List<Pokemon>

    suspend fun emptyTable()
}