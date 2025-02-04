package com.example.pokedexapp.common

fun getImageUrl(id: Int): String {
    return ImageUrl.replace("{id}", id.toString())
}