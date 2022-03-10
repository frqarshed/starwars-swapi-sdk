package com.sdk.starwars.presentation.core.model

import java.io.Serializable
import java.util.*

data class AllStarships(
    val currentTime: Long,
    val count: Int,
    val starships: List<Starship>
) : Serializable

data class Starship(
    val name: String,
    val model: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val costInCredits: String,
    val created: Date?,
    val edited: Date?,
    val crew: String,
    val hyperDriveRating: String,
    val length: String,
    val mGLT: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val starshipClass: String,
    val filmsIds: List<Int>,
    val pilotsIds: List<Int>,
) : Serializable