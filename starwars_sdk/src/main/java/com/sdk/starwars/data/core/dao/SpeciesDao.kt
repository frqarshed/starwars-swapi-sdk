package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.SpeciesApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllSpeciesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.SpeciesDto
import com.sdk.starwars.domain.repository.SpeciesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class SpeciesDao @Inject constructor(
    private val api: SpeciesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SpeciesRepository {

    override suspend fun getAllSpecies(pageNumber: Int): Result<AllSpeciesDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllSpecies(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getSpecie(specieId: Int): Result<SpeciesDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getSpecies(specieId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "Specie not found with ID: $specieId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchSpecies(name: String): Result<AllSpeciesDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchSpeciesWithName(name).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }


}
