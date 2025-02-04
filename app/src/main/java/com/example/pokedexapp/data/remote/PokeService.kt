package com.example.pokedexapp.data.remote

import com.example.pokedexapp.data.model.PokedexResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon")
    suspend fun getAllPokemons(@Query("limit") limit: Int): PokedexResponse
}