package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.PeopleApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllPeopleDto
import com.sdk.starwars.domain.model.PeopleDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PeopleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class PeopleDao @Inject constructor(
    private val api: PeopleApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PeopleRepository {

    override suspend fun getAllPeople(pageNumber: Int): Result<AllPeopleDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllPeople(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getPeople(peopleId: Int): Result<PeopleDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getPeople(peopleId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "People not found with ID: $peopleId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchPeople(name: String): Result<AllPeopleDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchPeopleWithName(name).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}
