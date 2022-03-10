package com.sdk.starwars.domain.interactor.exception

internal class ObjectNotFoundException(message: String? = null, cause: Throwable? = null) :
    BaseException(message, cause)