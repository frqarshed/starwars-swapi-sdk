package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import com.sdk.starwars.data.core.network.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface VehiclesApi {
    @GET("vehicles")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllVehicles(@Query("page") pageNumber: Int): GetAllVehiclesResponse

    @GET("vehicles/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getVehicles(@Path("id") id: Int): Vehicle

    @GET("vehicles")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchVehicles(@Query("search") nameOrModel: String): GetAllVehiclesResponse
}

internal data class GetAllVehiclesResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Vehicle> = emptyList()
) : Response()

internal data class Vehicle(
    @SerializedName("cargo_capacity") val cargoCapacity: String,
    @SerializedName("consumables") val consumables: String,
    @SerializedName("cost_in_credits") val costInCredits: String,
    @SerializedName("created") val created: String,
    @SerializedName("crew") val crew: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("length") val length: String,
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    @SerializedName("model") val model: String,
    @SerializedName("name") val name: String,
    @SerializedName("passengers") val passengers: String,
    @SerializedName("pilots") val pilots: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("vehicle_class") val vehicleClass: String
) : Response()