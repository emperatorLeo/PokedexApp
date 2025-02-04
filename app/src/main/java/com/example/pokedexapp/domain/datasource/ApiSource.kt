package com.example.pokedexapp.domain.datasource

import com.example.pokedexapp.data.model.PokedexResponse
import com.example.pokedexapp.data.model.PokemonResponse

interface ApiSource {
    suspend fun getAllPokemons(limit: Int): PokedexResponse

    suspend fun getOnePokemn(id: Int): PokemonResponse
}