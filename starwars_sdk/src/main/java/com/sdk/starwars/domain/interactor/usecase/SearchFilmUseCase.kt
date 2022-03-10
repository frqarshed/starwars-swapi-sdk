package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllFilmsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.FilmsRepository
import javax.inject.Inject

internal class SearchFilmUseCase @Inject constructor(
    private val repo: FilmsRepository
) : UseCase<Result<AllFilmsDto>, SearchFilmUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllFilmsDto> {
        params!!
        return repo.searchFilm(title = params.title)
    }

    data class Params(
        val title: String
    )
}