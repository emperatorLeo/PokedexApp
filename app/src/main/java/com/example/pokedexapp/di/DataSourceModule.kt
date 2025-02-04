package com.example.pokedexapp.di

import android.content.Context
import androidx.room.Room
import com.example.pokedexapp.data.localdatasource.LocalDataSource
import com.example.pokedexapp.data.localdatasource.LocalDataSourceImp
import com.example.pokedexapp.data.localdatasource.PokeDatabase
import com.example.pokedexapp.data.remote.PokeService
import com.example.pokedexapp.data.remotedatasource.ApiSource
import com.example.pokedexapp.data.remotedatasource.ApiSourceImp
import com.example.pokedexapp.data.repository.Repository
import com.example.pokedexapp.data.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRepository(apiSource: ApiSource, localDataSource: LocalDataSource): Repository {
        return RepositoryImp(apiSource, localDataSource)
    }

    @Singleton
    @Provides
    fun provideApiSource(pokeService: PokeService): ApiSource {
        return ApiSourceImp(pokeService)
    }

    @Singleton
    @Provides
    fun providePokeService(retrofit: Retrofit): PokeService {
        return retrofit.create(PokeService::class.java)
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext appContext: Context): PokeDatabase {
        return Room.databaseBuilder(appContext, PokeDatabase::class.java, "PokeDatabase").build()
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(db: PokeDatabase): LocalDataSource {
        return LocalDataSourceImp(db)
    }
}