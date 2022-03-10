package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface StarshipsApi {
    @GET("starships")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllStarships(@Query("page") pageNumber: Int): GetAllStarshipsResponse

    @GET("starships/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getStarships(@Path("id") id: Int): Starship

    @GET("starships")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchStarships(@Query("search") nameOrModel: String): GetAllStarshipsResponse
}

internal data class GetAllStarshipsResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Starship> = emptyList()
)

internal data class Starship(
    @SerializedName("cargo_capacity") val cargoCapacity: String,
    @SerializedName("consumables") val consumables: String,
    @SerializedName("cost_in_credits") val costInCredits: String,
    @SerializedName("created") val created: String,
    @SerializedName("crew") val crew: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("hyperdrive_rating") val hyperdriveRating: String,
    @SerializedName("length") val length: String,
    @SerializedName("MGLT") val mGLT: String,
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    @SerializedName("model") val model: String,
    @SerializedName("name") val name: String,
    @SerializedName("passengers") val passengers: String,
    @SerializedName("pilots") val pilots: List<String>,
    @SerializedName("starship_class") val starshipClass: String,
    @SerializedName("url") val url: String
)