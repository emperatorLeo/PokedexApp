package com.example.pokedexapp.domain.model

data class PokemonDto(
    val id: Int,
    val name: String,
    val type: List<String>,
    val baseExperience: Int,
    val height: Int,
    val movements: List<Movement>
)

data class Movement(
    val movementName: String,
    val movementLearnAt: Int
)