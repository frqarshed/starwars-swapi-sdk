package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllPeopleDto(
    val currentTime: Long,
    val count: Int,
    val peoples: List<PeopleDto>
) : Serializable

internal data class PeopleDto(
    val birthYear: String,
    val created: Date?,
    val edited: Date?,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorld: Planets?,
    val mass: String,
    val name: String,
    val skinColor: String,
    val films: List<Films>?,
    val species: List<Species>?,
    val starships: List<Starships>?,
    val vehicles: List<Vehicles>?,
    private val url: String,
) : Serializable, Link(url) {
    override fun getType(): String = PEOPLE
}