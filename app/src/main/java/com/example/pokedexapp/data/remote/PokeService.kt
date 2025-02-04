package com.example.pokedexapp.data.remote

import com.example.pokedexapp.data.model.PokedexResponse
import com.example.pokedexapp.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon")
    suspend fun getAllPokemons(@Query("limit") limit: Int): PokedexResponse

    @GET("pokemon/{pokemonId}")
    suspend fun getOnePokemon(@Path("pokemonId") id:Int): PokemonResponse
}