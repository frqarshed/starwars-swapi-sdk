package com.sdk.starwars.domain.repository

import com.sdk.starwars.domain.model.AllStarshipsDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.model.StarshipDto

internal interface StarshipsRepository {
    suspend fun getAllStarShips(pageNumber: Int = 1): Result<AllStarshipsDto>

    suspend fun getStarShip(starShipsId: Int): Result<StarshipDto>

    suspend fun searchStarShipsByName(name: String): Result<AllStarshipsDto>

    suspend fun searchStarShipsByModel(model: String): Result<AllStarshipsDto>
}