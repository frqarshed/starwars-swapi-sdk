package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllVehiclesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.VehicleDto

internal interface VehiclesRepository {
    suspend fun getAllVehicles(pageNumber: Int = 1): Result<AllVehiclesDto>

    suspend fun getVehicles(vehiclesId: Int): Result<VehicleDto>

    suspend fun searchVehiclesByName(name: String): Result<AllVehiclesDto>

    suspend fun searchVehiclesByModel(model: String): Result<AllVehiclesDto>
}