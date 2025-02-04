package com.example.pokedexapp.data.remotedatasource

import arrow.core.Either
import com.example.pokedexapp.domain.model.PokedexDto
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow

interface ApiSource {
    suspend fun getAllPokemons(limit: Int): Flow<Either<Error, ArrayList<PokedexDto>>>

    suspend fun getOnePokemon(id: Int): Flow<Either<Error, PokemonDto>>
}