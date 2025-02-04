package com.example.pokedexapp.di

import com.example.pokedexapp.domain.usecase.GetAllPokemonsFromDBUseCase
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetPokemonInfoUseCase
import com.example.pokedexapp.domain.usecase.InsertListOfPokemonsUseCase
import com.example.pokedexapp.domain.usecase.SearchPokemonUseCase
import com.example.pokedexapp.presentation.viewmodel.PokeSharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideViewModel(
        getAllPokemonsUseCase: GetAllPokemonsUseCase,
        getPokemonInfoUseCase: GetPokemonInfoUseCase,
        getAllPokemonsFromDBUseCase: GetAllPokemonsFromDBUseCase,
        searchPokemonUseCase: SearchPokemonUseCase,
        insertListOfPokemonsUseCase: InsertListOfPokemonsUseCase,
    ): PokeSharedViewModel {
        return PokeSharedViewModel(
            getAllPokemonsUseCase,
            getPokemonInfoUseCase,
            getAllPokemonsFromDBUseCase,
            insertListOfPokemonsUseCase,
            searchPokemonUseCase
        )
    }
}