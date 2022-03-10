package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllFilmsDto
import com.sdk.starwars.domain.model.FilmsDto
import com.sdk.starwars.domain.model.Result

internal interface FilmsRepository {
    suspend fun getAllFilms(pageNumber: Int = 1): Result<AllFilmsDto>

    suspend fun getFilm(filmId: Int): Result<FilmsDto>

    suspend fun searchFilm(title: String): Result<AllFilmsDto>
}