package com.sdk.starwars.domain.interactor.exception

import java.io.IOException

internal class ConnectivityException(message: String? = null, cause: Throwable? = null) :
    IOException(message, cause)