package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllPlanetDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PlanetRepository
import javax.inject.Inject

internal class SearchPlanetUseCase @Inject constructor(
    private val repo: PlanetRepository
) : UseCase<Result<AllPlanetDto>, SearchPlanetUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllPlanetDto> {
        params!!
        return repo.searchPlanet(params.name)
    }

    data class Params(
        val name: String
    )
}