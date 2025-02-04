package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.model.PokedexResponse
import com.example.pokedexapp.data.model.PokemonResponse

interface Repository {
    suspend fun getAllPokemons(limit:Int): PokedexResponse

    suspend fun getOnePokemn(id: Int): PokemonResponse
}