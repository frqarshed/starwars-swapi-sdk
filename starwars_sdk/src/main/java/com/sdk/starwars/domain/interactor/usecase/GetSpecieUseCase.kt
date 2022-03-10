package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.SpeciesDto
import com.sdk.starwars.domain.repository.SpeciesRepository
import javax.inject.Inject

internal class GetSpecieUseCase @Inject constructor(
    private val repo: SpeciesRepository
) : UseCase<Result<SpeciesDto>, GetSpecieUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<SpeciesDto> {
        params!!
        return repo.getSpecie(params.specieId)
    }

    data class Params(
        val specieId: Int
    )
}