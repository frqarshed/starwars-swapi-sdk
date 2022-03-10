package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface SpeciesApi {
    @GET("species")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllSpecies(@Query("page") pageNumber: Int): GetAllSpeciesResponse

    @GET("species/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getSpecies(@Path("id") id: Int): Specie

    @GET("species")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchSpeciesWithName(@Query("search") name: String): GetAllSpeciesResponse
}

internal data class GetAllSpeciesResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Specie> = emptyList()
)

internal data class Specie(
    @SerializedName("average_height") val averageHeight: String,
    @SerializedName("average_lifespan") val averageLifespan: String,
    @SerializedName("classification") val classification: String,
    @SerializedName("created") val created: String,
    @SerializedName("designation") val designation: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("eye_colors") val eyeColors: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("hair_colors") val hairColors: String,
    @SerializedName("homeworld") val homeworld: String?,
    @SerializedName("language") val language: String,
    @SerializedName("name") val name: String,
    @SerializedName("people") val people: List<String>,
    @SerializedName("skin_colors") val skinColors: String,
    @SerializedName("url") val url: String
)