package com.sdk.starwars.presentation.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule(private val context: Context) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context =
        context
}