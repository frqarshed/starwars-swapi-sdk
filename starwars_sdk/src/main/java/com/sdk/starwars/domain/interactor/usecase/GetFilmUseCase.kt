package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.FilmsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.FilmsRepository
import javax.inject.Inject

internal class GetFilmUseCase @Inject constructor(
    private val repo: FilmsRepository
) : UseCase<Result<FilmsDto>, GetFilmUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<FilmsDto> {
        params!!
        return repo.getFilm(filmId = params.filmId)
    }

    data class Params(
        val filmId: Int
    )
}