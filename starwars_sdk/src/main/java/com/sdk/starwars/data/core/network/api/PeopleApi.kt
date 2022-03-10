package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface PeopleApi {
    @GET("people")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllPeople(@Query("page") pageNumber: Int): GetAllPeopleResponse

    @GET("people/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getPeople(@Path("id") id: Int): People

    @GET("people")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchPeopleWithName(@Query("search") name: String): GetAllPeopleResponse
}

internal data class GetAllPeopleResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<People> = emptyList()
)

internal data class People(
    @SerializedName("birth_year") val birthYear: String,
    @SerializedName("created") val created: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("eye_color") val eyeColor: String,
    @SerializedName("films") val films: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("height") val height: String,
    @SerializedName("homeworld") val homeworld: String,
    @SerializedName("mass") val mass: String,
    @SerializedName("name") val name: String,
    @SerializedName("skin_color") val skinColor: String,
    @SerializedName("species") val species: List<String>,
    @SerializedName("starships") val starships: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("vehicles") val vehicles: List<String>,
    @SerializedName("detail") val detail: String? = null
)