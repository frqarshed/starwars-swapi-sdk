package com.sdk.starwars.domain.interactor.exception

internal open class BaseException(
    val response: String? = null,
    cause: Throwable? = null,
) : RuntimeException(cause)