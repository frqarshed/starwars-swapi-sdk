package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllVehiclesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.VehiclesRepository
import javax.inject.Inject

internal class SearchVehicleByNameUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<AllVehiclesDto>, SearchVehicleByNameUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllVehiclesDto> {
        params!!
        return repo.searchVehiclesByName(params.name)
    }

    data class Params(
        val name: String
    )
}