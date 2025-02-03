package com.example.pokedexapp.domain.repository

import okhttp3.ResponseBody
import retrofit2.Call

interface Repository {
    suspend fun goCatchThemAll(limit:Int): Call<ResponseBody>
}