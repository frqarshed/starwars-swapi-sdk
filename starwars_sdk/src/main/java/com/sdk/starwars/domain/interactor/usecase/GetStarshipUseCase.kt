package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.StarshipDto
import com.sdk.starwars.domain.repository.StarshipsRepository
import javax.inject.Inject

internal class GetStarshipUseCase @Inject constructor(
    private val repo: StarshipsRepository
) : UseCase<Result<StarshipDto>, GetStarshipUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<StarshipDto> {
        params!!
        return repo.getStarShip(params.starshipId)
    }

    data class Params(
        val starshipId: Int
    )
}