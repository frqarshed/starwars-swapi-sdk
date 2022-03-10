package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.VehicleDto
import com.sdk.starwars.domain.repository.VehiclesRepository
import javax.inject.Inject

internal class GetVehicleUseCase @Inject constructor(
    private val repo: VehiclesRepository
) : UseCase<Result<VehicleDto>, GetVehicleUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<VehicleDto> {
        params!!
        return repo.getVehicles(params.vehicleId)
    }

    data class Params(
        val vehicleId: Int
    )
}