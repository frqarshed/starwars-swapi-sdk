package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllSpeciesDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.SpeciesDto

internal interface SpeciesRepository {
    suspend fun getAllSpecies(pageNumber: Int = 1): Result<AllSpeciesDto>

    suspend fun getSpecie(specieId: Int): Result<SpeciesDto>

    suspend fun searchSpecies(name: String): Result<AllSpeciesDto>
}