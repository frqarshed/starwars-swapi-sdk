package com.sdk.starwars.presentation.core.interactor.exception

class NoInternetException(message: String? = null, cause: Throwable? = null) :
    BaseException(message, cause) {

    override val message: String
        get() = "No network available, please check your WiFi or Data connection"
}