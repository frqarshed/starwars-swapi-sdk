package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllSpeciesDto(
    val currentTime: Long,
    val count: Int,
    val species: List<SpeciesDto>
) : Serializable

internal data class SpeciesDto(
    val name: String,
    val averageHeight: String,
    val averageLifespan: String,
    val classification: String,
    val designation: String,
    val eyeColors: String,
    val hairColors: String,
    val language: String,
    val skinColors: String,
    val homeWorld: Planets?,
    val films: List<Films>?,
    val people: List<Peoples>?,
    val created: Date?,
    val edited: Date?,
    private val url: String
) : Serializable, Link(url) {
    override fun getType(): String = SPECIES
}