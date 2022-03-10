package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllFilmsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.FilmsRepository
import javax.inject.Inject

internal class GetAllFilmsUseCase @Inject constructor(
    private val repo: FilmsRepository
) : UseCase<Result<AllFilmsDto>, GetAllFilmsUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllFilmsDto> {
        params!!
        return repo.getAllFilms()
    }

    data class Params(
        val pageNumber: Int
    )
}