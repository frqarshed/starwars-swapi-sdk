package com.sdk.starwars.presentation.core.di

import com.sdk.starwars.data.core.dao.*
import com.sdk.starwars.data.core.network.NetworkDataSource
import com.sdk.starwars.domain.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideFilmsRepository(
        dataSource: NetworkDataSource
    ): FilmsRepository =
        FilmsDao(dataSource)

    @Provides
    @Singleton
    internal fun providePeopleRepository(
        dataSource: NetworkDataSource
    ): PeopleRepository =
        PeopleDao(dataSource)

    @Provides
    @Singleton
    internal fun providePlanetRepository(
        dataSource: NetworkDataSource
    ): PlanetRepository =
        PlanetDao(dataSource)

    @Provides
    @Singleton
    internal fun provideSpeciesRepository(
        dataSource: NetworkDataSource
    ): SpeciesRepository =
        SpeciesDao(dataSource)

    @Provides
    @Singleton
    internal fun provideStarshipsRepository(
        dataSource: NetworkDataSource
    ): StarshipsRepository =
        StarshipsDao(dataSource)

    @Provides
    @Singleton
    internal fun provideVehiclesRepository(
        dataSource: NetworkDataSource
    ): VehiclesRepository =
        VehiclesDao(dataSource)

}
