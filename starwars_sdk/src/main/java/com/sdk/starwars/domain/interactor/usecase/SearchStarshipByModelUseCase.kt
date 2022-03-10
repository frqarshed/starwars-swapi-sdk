package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllStarshipsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.StarshipsRepository
import javax.inject.Inject

internal class SearchStarshipByModelUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<AllStarshipsDto>, SearchStarshipByModelUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllStarshipsDto> {
        params!!
        return repo.searchStarShipsByModel(params.model)
    }

    data class Params(
        val model: String
    )
}