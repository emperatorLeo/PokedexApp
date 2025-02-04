package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.model.PokedexResponse

interface Repository {
    suspend fun goCatchThemAll(limit:Int): PokedexResponse
}