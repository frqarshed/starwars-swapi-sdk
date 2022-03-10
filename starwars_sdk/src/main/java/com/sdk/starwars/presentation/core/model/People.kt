package com.sdk.starwars.presentation.core.model

import java.io.Serializable
import java.util.*

data class AllPeople(
    val currentTime: Long,
    val count: Int,
    val people: List<People>
) : Serializable

data class People(
    val name: String,
    val birthYear: String,
    val created: Date?,
    val edited: Date?,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorldId: Int?,
    val mass: String,
    val skinColor: String,
    val filmsIds: List<Int>,
    val speciesIds: List<Int>,
    val starshipsIds: List<Int>,
    val vehiclesIds: List<Int>
) : Serializable