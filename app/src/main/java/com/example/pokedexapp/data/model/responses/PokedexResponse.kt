package com.example.pokedexapp.data.model.responses

import com.example.pokedexapp.domain.model.PokedexDto
import com.google.gson.annotations.SerializedName


data class PokedexResponse(@SerializedName("results") val results: ArrayList<PokedexItem>) {

    fun toPokedexDto(): ArrayList<PokedexDto> {
        val mappedList = arrayListOf<PokedexDto>()
        for (item in results) {
            item.apply {
                mappedList.add(PokedexDto(name = name, url = url))
            }
        }
        return mappedList
    }
}

data class PokedexItem(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)