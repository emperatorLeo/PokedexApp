package com.example.pokedexapp.data.localdatasource

import com.example.pokedexapp.data.model.entities.Pokemon
import kotlinx.coroutines.flow.flow

class LocalDataSourceImp(db: PokeDatabase) : LocalDataSource {
    private val dao = db.pokeDao()

    override suspend fun insertListPokemon(pokemonList: List<Pokemon>) {
        dao.insertPokemonList(pokemonList)
    }

    override suspend fun getAllPokemonsFromDB() = flow {
        dao.getAllPokemonFromDB().collect {
            emit(it.map { pokemon -> pokemon.fromEntityToDto() })
        }
    }

    override suspend fun searchPokemon(name: String) = flow {
        dao.getFilterPokemons(name).collect {
            emit(it.map { pokemon -> pokemon.fromEntityToDto() })
        }
    }
}