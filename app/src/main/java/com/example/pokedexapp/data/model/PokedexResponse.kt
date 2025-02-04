package com.example.pokedexapp.data.model

import com.google.gson.annotations.SerializedName


data class PokedexResponse(@SerializedName("results") val results: ArrayList<PokedexItem>)

data class PokedexItem(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)