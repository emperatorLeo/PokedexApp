package com.example.pokedexapp.domain.model

import com.example.pokedexapp.data.model.entities.MovementList
import com.example.pokedexapp.data.model.entities.Pokemon
import com.example.pokedexapp.data.model.entities.TypeList

data class PokemonDto(
    val id: Int,
    val name: String,
    val type: List<String>,
    val baseExperience: Int,
    val height: Int,
    val movements: List<Movement>
) {
    fun fromDtoToEntity(): Pokemon {
        this.apply {
            return Pokemon(
                id,
                name,
                TypeList(type),
                baseExperience,
                height,
                MovementList(movements)
            )
        }
    }
}

data class Movement(
    val movementName: String,
    val movementLearnAt: Int
)