package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface PlanetApi {
    @GET("planets")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllPlanet(@Query("page") pageNumber: Int): GetAllPlanetResponse

    @GET("planets/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getPlanet(@Path("id") id: Int): Planet

    @GET("planets")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchPlanetWithName(@Query("search") name: String): GetAllPlanetResponse
}

internal data class GetAllPlanetResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Planet> = emptyList()
)

internal data class Planet(
    @SerializedName("climate") val climate: String,
    @SerializedName("created") val created: String,
    @SerializedName("diameter") val diameter: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("gravity") val gravity: String,
    @SerializedName("name") val name: String,
    @SerializedName("orbital_period") val orbitalPeriod: String,
    @SerializedName("population") val population: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("rotation_period") val rotationPeriod: String,
    @SerializedName("surface_water") val surfaceWater: String,
    @SerializedName("terrain") val terrain: String,
    @SerializedName("url") val url: String
)