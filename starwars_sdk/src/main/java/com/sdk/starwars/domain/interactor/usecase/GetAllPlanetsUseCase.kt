package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllPlanetDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PlanetRepository
import javax.inject.Inject

internal class GetAllPlanetsUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<AllPlanetDto>, GetAllPlanetsUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllPlanetDto> {
        params!!
        return repo.getAllPlanet()
    }

    data class Params(
        val pageNumber: Int
    )
}