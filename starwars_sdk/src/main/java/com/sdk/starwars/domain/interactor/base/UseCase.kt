package com.sdk.starwars.domain.interactor.base

internal abstract class UseCase<T, in P> {
    abstract suspend fun execute(params: P? = null): T
}