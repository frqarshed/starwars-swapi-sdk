package com.sdk.starwars.data.core.dao

import com.sdk.starwars.data.core.network.api.FilmsApi
import com.sdk.starwars.data.core.network.toDomain
import com.sdk.starwars.domain.interactor.exception.ObjectNotFoundException
import com.sdk.starwars.domain.model.AllFilmsDto
import com.sdk.starwars.domain.model.FilmsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.FilmsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

internal class FilmsDao @Inject constructor(
    private val api: FilmsApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : FilmsRepository {

    override suspend fun getAllFilms(pageNumber: Int): Result<AllFilmsDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getAllFilms(pageNumber).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

    override suspend fun getFilm(filmId: Int): Result<FilmsDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.getFilm(filmId).toDomain())
            } catch (e: Exception) {
                if ((e is HttpException) && e.code() == 404) {
                    Result.Error(
                        ObjectNotFoundException(
                            "Film not found with ID: $filmId"
                        )
                    )
                } else {
                    Result.Error(e)
                }
            }
        }

    override suspend fun searchFilm(title: String): Result<AllFilmsDto> =
        withContext(ioDispatcher) {
            try {
                Result.Success(api.searchFilmWithTitle(title).toDomain())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}
