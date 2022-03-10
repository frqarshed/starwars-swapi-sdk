package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllPeopleDto
import com.sdk.starwars.domain.model.PeopleDto
import com.sdk.starwars.domain.model.Result

internal interface PeopleRepository {
    suspend fun getAllPeople(pageNumber: Int = 1): Result<AllPeopleDto>

    suspend fun getPeople(peopleId: Int): Result<PeopleDto>

    suspend fun searchPeople(name: String): Result<AllPeopleDto>
}