package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.StarshipsApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllStarshipsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.StarshipDto
import com.sdk.starwars.domain.repository.StarshipsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class StarshipsDao @Inject constructor(
    private val api: StarshipsApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : StarshipsRepository {
    override suspend fun getAllStarShips(pageNumber: Int): Result<AllStarshipsDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllStarships(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getStarShip(starShipsId: Int): Result<StarshipDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getStarships(starShipsId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "Starship not found with ID: $starShipsId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchStarShipsByName(name: String): Result<AllStarshipsDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchStarships(name).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun searchStarShipsByModel(model: String): Result<AllStarshipsDto> =
        searchStarShipsByName(model)


}
