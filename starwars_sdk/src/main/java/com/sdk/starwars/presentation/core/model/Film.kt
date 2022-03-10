package com.sdk.starwars.presentation.core.model

import java.io.Serializable
import java.util.*

data class AllFilms(
    val currentTime: Long,
    val count: Int,
    val films: List<Film>
) : Serializable

data class Film(
    val title: String,
    val created: Date?,
    val director: String,
    val edited: Date?,
    val episodeId: Int,
    val openingCrawl: String,
    val producer: String,
    val releaseDate: Date?,
    val charactersIds: List<Int>,
    val speciesIds: List<Int>,
    val vehiclesIds: List<Int>,
    val starshipsIds: List<Int>,
    val planetsIds: List<Int>
) : Serializable