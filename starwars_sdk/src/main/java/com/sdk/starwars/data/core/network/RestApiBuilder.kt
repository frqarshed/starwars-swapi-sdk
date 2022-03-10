package com.sdk.starwars.data.core.network

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.sdk.presentation.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class RestApiBuilder(
    private val context: Context,
    private val host: String,
    private val connectTimeout: Long = 30,
    private val readTimeout: Long = 30
) {

    fun build(): Retrofit = Retrofit.Builder()
        .baseUrl(host)
        .client(okHttpClient())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()

    private fun okHttpClient() = OkHttpClient.Builder()
        .connectTimeout(connectTimeout, TimeUnit.SECONDS)
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .addInterceptor(ConnectivityInterceptor(context))
        .logging()
        .build()

    private fun gson() = GsonBuilder()
        .setLenient()
        .enableComplexMapKeySerialization()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
}

internal fun OkHttpClient.Builder.logging(): OkHttpClient.Builder =
    apply {
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            addInterceptor(httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            })
        }
    }