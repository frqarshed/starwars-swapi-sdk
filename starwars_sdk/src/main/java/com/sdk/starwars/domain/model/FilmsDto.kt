package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllFilmsDto(
    val currentTime: Long,
    val count: Int,
    val films: List<FilmsDto>
) : Serializable

internal data class FilmsDto(
    val title: String,
    val created: Date?,
    val director: String,
    val edited: Date?,
    val episodeId: Int,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: Date?,
    val characters: List<Peoples>?,
    val species: List<Species>?,
    val vehicles: List<Vehicles>?,
    val starships: List<Starships>?,
    val planets: List<Planets>?,
    private val url: String,
) : Serializable, Link(url) {
    override fun getType(): String = FILMS
}