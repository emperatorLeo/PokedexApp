package com.example.pokedexapp.domain.usecase

import com.example.pokedexapp.data.repository.Repository
import javax.inject.Inject

class GetAllPokemonsFromDBUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() = repository.getAllPokemonsFromDB()

}