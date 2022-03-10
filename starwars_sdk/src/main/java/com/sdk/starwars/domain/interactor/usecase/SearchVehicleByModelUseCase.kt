package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllVehiclesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.VehiclesRepository
import javax.inject.Inject

internal class SearchVehicleByModelUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<AllVehiclesDto>, SearchVehicleByModelUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllVehiclesDto> {
        params!!
        return repo.searchVehiclesByModel(params.model)
    }

    data class Params(
        val model: String
    )
}