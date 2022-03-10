package com.sdk.starwars.data.core.network.api

import com.google.gson.annotations.SerializedName
import com.sdk.starwars.data.core.network.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


internal interface FilmsApi {
    @GET("films")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getAllFilms(@Query("page") pageNumber: Int): GetAllFilmsResponse

    @GET("films/{id}/")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun getFilm(@Path("id") id: Int): Film

    @GET("films")
    @Headers(
        "Content-type: application/json"
    )
    suspend fun searchFilmWithTitle(@Query("search") title: String): GetAllFilmsResponse
}

internal data class GetAllFilmsResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Film> = emptyList()
) : Response()

internal data class Film(
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("created") val created: String,
    @SerializedName("director") val director: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("episode_id") val episodeId: Int,
    @SerializedName("opening_crawl") val openingCrawl: String,
    @SerializedName("planets") val planets: List<String>,
    @SerializedName("producer") val producer: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("species") val species: List<String>,
    @SerializedName("starships") val starships: List<String>,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("vehicles") val vehicles: List<String>
)