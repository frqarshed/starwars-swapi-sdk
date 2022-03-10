package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllPlanetDto(
    val currentTime: Long,
    val count: Int,
    val planets: List<PlanetDto>
) : Serializable

internal data class PlanetDto(
    val climate: String,
    val diameter: String,
    val created: Date?,
    val edited: Date?,
    val gravity: String,
    val name: String,
    val orbitalPeriod: String,
    val population: String,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String,
    val films: List<Films>?,
    val residents: List<Peoples>?,
    private val url: String
) : Serializable, Link(url) {
    override fun getType(): String = PLANETS
}