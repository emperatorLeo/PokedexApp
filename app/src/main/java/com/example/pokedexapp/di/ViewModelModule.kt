package com.example.pokedexapp.di

import com.example.pokedexapp.domain.repository.Repository
import com.example.pokedexapp.domain.usecase.GetAllPokemonsUseCase
import com.example.pokedexapp.ui.viewmodel.PokeSharedViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideViewModel(getAllPokemonsUseCase: GetAllPokemonsUseCase):PokeSharedViewModel {
        return PokeSharedViewModel(getAllPokemonsUseCase)
    }

    @Provides
    fun provideGetAllPokemonsUseCase(repository: Repository): GetAllPokemonsUseCase {
        return GetAllPokemonsUseCase(repository)
    }
}