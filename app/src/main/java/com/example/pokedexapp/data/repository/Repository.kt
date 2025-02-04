package com.example.pokedexapp.data.repository

import arrow.core.Either
import com.example.pokedexapp.data.model.entities.Pokemon
import com.example.pokedexapp.domain.model.PokedexDto
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllPokemons(limit:Int): Flow<Either<Error, ArrayList<PokedexDto>>>

    suspend fun getOnePokemon(id: Int): Flow<Either<Error, PokemonDto>>

    suspend fun insertSinglePokemon(pokemon: Pokemon)

    suspend fun insertListPokemon(pokemonList: List<Pokemon>)

    suspend fun getAllPokemonsFromDB(): List<Pokemon>

    suspend fun searchPokemon(name: String): List<Pokemon>

    suspend fun emptyTable()
}