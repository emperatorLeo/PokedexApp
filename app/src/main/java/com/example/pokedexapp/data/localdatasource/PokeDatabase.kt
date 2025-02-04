package com.example.pokedexapp.data.localdatasource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedexapp.data.converters.RoomTypeConverters
import com.example.pokedexapp.data.model.entities.Pokemon

@TypeConverters(value = [RoomTypeConverters::class])
@Database(entities = [Pokemon::class], version = 1)
abstract class PokeDatabase: RoomDatabase() {
    abstract fun pokeDao(): PokeDao

}