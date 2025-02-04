package com.example.pokedexapp.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("forms") val arrayList: ArrayList<PokemonForm>,
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("moves") val moves: ArrayList<PokemonMovement>,
    @SerializedName("types") val types: ArrayList<PokemonType>
)

data class PokemonForm(
    @SerializedName("name") val name: String
)

data class PokemonMovement(
    @SerializedName("move") val move: Move,
    @SerializedName("version_group_details") val groupDetails: ArrayList<GroupDetails>
)

data class Move(
    @SerializedName("name") val movementName: String,
)

data class GroupDetails(
    @SerializedName("level_learned_at") val levelLearned: Int
)

data class PokemonType(
    @SerializedName("type") val type: Type
)

data class Type(
    @SerializedName("name") val typeName: String
)