package com.example.pokedexapp.common

fun getImageUrl(id: Int): String {
    return IMAGE_URL.replace("{id}", id.toString())
}