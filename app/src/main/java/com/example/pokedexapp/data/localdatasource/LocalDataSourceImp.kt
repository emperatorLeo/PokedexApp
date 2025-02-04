package com.example.pokedexapp.data.localdatasource

import com.example.pokedexapp.data.model.entities.Pokemon

class LocalDataSourceImp(db: PokeDatabase) : LocalDataSource {
    private val dao = db.pokeDao()

    override suspend fun insertSinglePokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun insertListPokemon(pokemonList: List<Pokemon>) {
        dao.insertPokemonList(pokemonList)
    }

    override suspend fun getAllPokemonsFromDB(): List<Pokemon> {
        return dao.getAllPokemonFromDB()
    }

    override suspend fun searchPokemon(name: String): List<Pokemon> {
        return dao.getFilterPokemons(name)
    }

    override suspend fun emptyTable() {
        dao.deleteTable()
    }
}