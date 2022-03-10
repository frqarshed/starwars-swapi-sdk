package com.sdk.starwars.presentation.core.di

import android.content.Context
import com.sdk.starwars.data.core.Constants.HOST_API
import com.sdk.starwars.data.core.network.NetworkDataSource
import com.sdk.starwars.data.core.network.RestApiBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
internal class NetworkModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(context: Context) =
        RestApiBuilder(context, HOST_API).build()

    @Provides
    @Singleton
    internal fun provideNetworkDataSource(
        retrofit: Retrofit
    ): NetworkDataSource =
        NetworkDataSource(retrofit)
}
