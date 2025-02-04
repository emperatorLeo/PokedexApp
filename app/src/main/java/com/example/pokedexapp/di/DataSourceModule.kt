package com.example.pokedexapp.di

import com.example.pokedexapp.data.remote.PokeService
import com.example.pokedexapp.data.datasource.ApiSourceImp
import com.example.pokedexapp.data.repository.RepositoryImp
import com.example.pokedexapp.data.datasource.ApiSource
import com.example.pokedexapp.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRepository(apiSource: ApiSource): Repository {
        return RepositoryImp(apiSource)
    }

    @Singleton
    @Provides
    fun provideApiSource(pokeService: PokeService): ApiSource {
        return ApiSourceImp(pokeService)
    }

    @Singleton
    @Provides
    fun providePokeService(retrofit: Retrofit): PokeService {
        return  retrofit.create(PokeService::class.java)
    }
}