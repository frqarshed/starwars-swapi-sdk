package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.PlanetApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllPlanetDto
import com.sdk.starwars.domain.model.PlanetDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PlanetRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class PlanetDao @Inject constructor(
    private val api: PlanetApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlanetRepository {

    override suspend fun getAllPlanet(pageNumber: Int): Result<AllPlanetDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllPlanet(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getPlanet(planetId: Int): Result<PlanetDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getPlanet(planetId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "Planet not found with ID: $planetId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchPlanet(name: String): Result<AllPlanetDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchPlanetWithName(name).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}
