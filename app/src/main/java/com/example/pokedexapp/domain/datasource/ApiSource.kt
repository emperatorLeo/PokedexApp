package com.example.pokedexapp.domain.datasource

import com.example.pokedexapp.data.model.PokedexResponse

interface ApiSource {
    suspend fun getAllPokemons(limit: Int): PokedexResponse
}