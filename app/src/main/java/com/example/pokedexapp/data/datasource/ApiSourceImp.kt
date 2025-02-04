package com.example.pokedexapp.data.datasource

import arrow.core.Either
import com.example.pokedexapp.data.remote.PokeService
import com.example.pokedexapp.domain.model.PokedexDto
import com.example.pokedexapp.domain.model.PokemonDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiSourceImp(private val pokeService: PokeService) : ApiSource {

    override suspend fun getAllPokemons(limit: Int): Flow<Either<Error, ArrayList<PokedexDto>>> =
        flow {
            val response = pokeService.getAllPokemons(limit)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Either.Right(it.toPokedexDto()))
                }
            } else {
                emit(Either.Left(Error(response.errorBody()?.string())))
            }
        }


    override suspend fun getOnePokemon(id: Int): Flow<Either<Error, PokemonDto>> = flow {
        val response = pokeService.getOnePokemon(id)

        if (response.isSuccessful) {
            response.body()?.let {
                emit(Either.Right(it.toPokemonDto()))
            }
        } else {
            emit(Either.Left(Error(response.errorBody()?.string())))
        }
    }
}