package com.sdk.starwars.presentation.core.di

import com.sdk.starwars.presentation.core.main.StarWarsController
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
internal interface AppComponent {
    fun inject(frag: StarWarsController)
}

