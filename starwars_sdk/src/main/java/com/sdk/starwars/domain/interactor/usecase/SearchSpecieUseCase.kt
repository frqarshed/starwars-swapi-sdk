package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllSpeciesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.SpeciesRepository
import javax.inject.Inject

internal class SearchSpecieUseCase @Inject constructor(
    private val repo: SpeciesRepository
) : UseCase<Result<AllSpeciesDto>, SearchSpecieUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllSpeciesDto> {
        params!!
        return repo.searchSpecies(params.name)
    }

    data class Params(
        val name: String
    )
}