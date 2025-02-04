package com.example.pokedexapp.data.repository

import arrow.core.Either
import com.example.pokedexapp.domain.model.PokedexDto
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllPokemons(limit:Int): Flow<Either<Error, ArrayList<PokedexDto>>>

    suspend fun getOnePokemn(id: Int): Flow<Either<Error, PokemonDto>>
}