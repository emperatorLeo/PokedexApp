package com.example.pokedexapp.di

import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.domain.usecase.GetOnePokemonUseCase
import com.example.pokedexapp.ui.viewmodel.PokeSharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideViewModel(getAllPokemonsUseCase: GetAllPokemonsUseCase, getOnePokemonUseCase: GetOnePokemonUseCase):PokeSharedViewModel {
        return PokeSharedViewModel(getAllPokemonsUseCase, getOnePokemonUseCase)
    }
}