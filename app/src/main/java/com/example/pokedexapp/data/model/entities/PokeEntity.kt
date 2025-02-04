package com.example.pokedexapp.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexapp.domain.model.Movement
import com.example.pokedexapp.domain.model.PokemonDto

@Entity(tableName = "PokeTable")
data class Pokemon(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: TypeList,
    val baseExperience: Int,
    val height: Int,
    val movements: MovementList
) {
    fun fromEntityToDto(): PokemonDto {
        this.apply {
            return PokemonDto(
                id,
                name,
                type = type.types,
                baseExperience,
                height,
                movements = movements.movements
            )
        }
    }
}

data class MovementList(val movements: List<Movement>)
data class TypeList(val types: List<String>)