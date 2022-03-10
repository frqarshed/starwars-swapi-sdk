package com.sdk.starwars.data.core.network

import android.content.Context
import com.sdk.starwars.data.core.extension.isNetworkAvailable
import com.sdk.starwars.domain.interactor.exception.ConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

internal class ConnectivityInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!context.isNetworkAvailable()) {
            throw ConnectivityException()
        }

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}
