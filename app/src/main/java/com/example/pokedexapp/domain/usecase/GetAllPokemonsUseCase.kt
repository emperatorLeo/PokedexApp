package com.example.pokedexapp.domain.usecase

import android.util.Log
import com.example.pokedexapp.domain.repository.Repository
import com.example.pokedexapp.util.POKEMON_LIMIT
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() {
        val response = repository.goCatchThemAll(POKEMON_LIMIT)
        response.enqueue( object: Callback<ResponseBody> {
            override fun onResponse(p0: Call<ResponseBody>, p1: Response<ResponseBody>) {
                Log.d("Leo", "response : ${p1.body().toString()}")
            }

            override fun onFailure(p0: Call<ResponseBody>, p1: Throwable) {
                Log.d("Leo", "failure : ${p1.message}; ${p1.localizedMessage}")
            }
        })

    }
}