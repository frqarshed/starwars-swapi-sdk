package com.sdk.starwars.presentation.core.interactor.exception

open class BaseException(
    val response: String? = null,
    cause: Throwable? = null,
) : RuntimeException(cause)