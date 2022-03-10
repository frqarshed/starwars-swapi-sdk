package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.VehiclesApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllVehiclesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.VehicleDto
import com.sdk.starwars.domain.repository.VehiclesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class VehiclesDao @Inject constructor(
    private val api: VehiclesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : VehiclesRepository {

    override suspend fun getAllVehicles(pageNumber: Int): Result<AllVehiclesDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllVehicles(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getVehicles(vehiclesId: Int): Result<VehicleDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getVehicles(vehiclesId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "Vehicle not found with ID: $vehiclesId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchVehiclesByName(name: String): Result<AllVehiclesDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchVehicles(name).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun searchVehiclesByModel(model: String): Result<AllVehiclesDto> =
        searchVehiclesByName(model)

}
