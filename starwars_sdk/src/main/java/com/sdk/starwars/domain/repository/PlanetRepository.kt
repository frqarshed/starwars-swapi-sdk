package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllPlanetDto
import com.sdk.starwars.domain.model.PlanetDto
import com.sdk.starwars.domain.model.Result

internal interface PlanetRepository {
    suspend fun getAllPlanet(pageNumber: Int = 1): Result<AllPlanetDto>

    suspend fun getPlanet(planetId: Int): Result<PlanetDto>

    suspend fun searchPlanet(name: String): Result<AllPlanetDto>
}