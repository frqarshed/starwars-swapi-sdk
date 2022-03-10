package com.sdk.starwars.presentation.core.model

import java.io.Serializable
import java.util.*

data class AllSpecies(
    val currentTime: Long,
    val count: Int,
    val species: List<Species>
) : Serializable

data class Species(
    val name: String,
    val averageHeight: String,
    val averageLifespan: String,
    val classification: String,
    val designation: String,
    val eyeColors: String,
    val hairColors: String,
    val language: String,
    val skinColors: String,
    val homeWorldId: Int?,
    val filmsIds: List<Int>,
    val peopleIds: List<Int>,
    val created: Date?,
    val edited: Date?,
) : Serializable