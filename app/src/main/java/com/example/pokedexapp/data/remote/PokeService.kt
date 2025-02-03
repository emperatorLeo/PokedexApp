package com.example.pokedexapp.data.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon")
    fun getAllPokemons(@Query("limit") limit: Int): Call<ResponseBody>
}