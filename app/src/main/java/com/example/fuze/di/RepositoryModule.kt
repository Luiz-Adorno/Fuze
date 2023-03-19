package com.example.fuze.di

import com.example.fuze.network.api.TeamApi
import com.example.fuze.repository.TeamRepository
import com.example.fuze.repository.TeamRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTeamRepository(
        teamApi: TeamApi
    ): TeamRepository{
        return TeamRepositoryImpl(teamApi)
    }
}

