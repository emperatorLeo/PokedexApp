package com.example.pokedexapp.data.model.responses

import com.example.pokedexapp.domain.model.Movement
import com.example.pokedexapp.domain.model.PokemonDto
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("forms") val form: ArrayList<PokemonForm>,
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("moves") val moves: ArrayList<PokemonMovement>,
    @SerializedName("types") val types: ArrayList<PokemonType>
) {
    fun toPokemonDto(): PokemonDto {
        return PokemonDto(
            id = id,
            name = form.toList().first().name,
            type = toTypeList(types),
            baseExperience = baseExperience,
            height = height,
            movements = toMovementList(moves)
        )
    }

    private fun toTypeList(types: ArrayList<PokemonType>): List<String> {
        val list = arrayListOf<String>()

        for (type in types) {
            list.add(type.type.typeName)
        }
        return list
    }

    private fun toMovementList(moves: ArrayList<PokemonMovement>): List<Movement> {
        val list = arrayListOf<Movement>()
        for (movement in moves) {
            list.add(
                Movement(
                    movementName = movement.move.movementName,
                    movementLearnAt = movement.groupDetails.toList().first().levelLearned
                )
            )
            if (list.size >= 10)
                break
        }
        return list
    }
}

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