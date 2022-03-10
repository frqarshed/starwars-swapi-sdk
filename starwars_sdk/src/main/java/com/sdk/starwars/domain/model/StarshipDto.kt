package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllStarshipsDto(
    val currentTime: Long,
    val count: Int,
    val starships: List<StarshipDto>
) : Serializable

internal data class StarshipDto(
    val name: String,
    val model: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val costInCredits: String,
    val created: Date?,
    val crew: String,
    val edited: Date?,
    val hyperDriveRating: String,
    val length: String,
    val mGLT: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val starshipClass: String,
    val films: List<Films>?,
    val pilots: List<Peoples>?,
    private val url: String
) : Serializable, Link(url) {
    override fun getType(): String = STARSHIPS
}