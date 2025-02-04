package com.example.pokedexapp.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexapp.domain.model.Movement

@Entity(tableName = "PokeTable")
data class Pokemon(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: TypeList,
    val baseExperience: Int,
    val movements: MovementList
)

data class MovementList(val movements: List<Movement>)
data class TypeList(val types: List<String>)