package com.example.pokedexapp.data.localdatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedexapp.data.model.entities.Pokemon

@Dao
interface PokeDao {
    @Insert
    suspend fun insertPokemon(pokemon: Pokemon)

    @Insert
    suspend fun insertPokemonList(pokemonList: List<Pokemon>)

    @Query("SELECT * FROM PokeTable")
    suspend fun getAllPokemonFromDB(): List<Pokemon>

    @Query("SELECT * FROM PokeTable WHERE name LIKE :name")
    suspend fun getFilterPokemons(name:String): List<Pokemon>

    @Query("DELETE FROM PokeTable")
    suspend fun deleteTable()
}