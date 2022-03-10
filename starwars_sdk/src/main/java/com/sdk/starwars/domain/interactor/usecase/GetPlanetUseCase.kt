package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.PlanetDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PlanetRepository
import javax.inject.Inject

internal class GetPlanetUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<PlanetDto>, GetPlanetUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<PlanetDto> {
        params!!
        return repo.getPlanet(params.planetId)
    }

    data class Params(
        val planetId: Int
    )
}