package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllStarshipsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.StarshipsRepository
import javax.inject.Inject

internal class SearchStarshipByNameUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<AllStarshipsDto>, SearchStarshipByNameUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllStarshipsDto> {
        params!!
        return repo.searchStarShipsByName(params.name)
    }

    data class Params(
        val name: String
    )
}