package com.example.pokedexapp.domain.datasource

import okhttp3.ResponseBody
import retrofit2.Call

interface ApiSource {
    suspend fun getAllPokemons(limit: Int): Call<ResponseBody>
}