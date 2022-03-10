package com.sdk.starwars.presentation.core.model

import com.sdk.starwars.domain.interactor.exception.ConnectivityException
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.presentation.core.interactor.exception.BaseException
import com.sdk.starwars.presentation.core.interactor.exception.NoInternetException
import com.sdk.starwars.presentation.core.interactor.exception.ObjectNotFoundException as OE

sealed class Response<out R> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(private val exception: Exception) : Response<Nothing>() {
        fun getException(): BaseException = when (exception) {
            is ConnectivityException -> {
                NoInternetException()
            }
            is ObjectNotFoundException -> {
                OE(exception.response, exception)
            }
            else -> {
                BaseException(exception.message, exception)
            }
        }
    }
}