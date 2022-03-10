package com.sdk.starwars.presentation.core.model

import java.io.Serializable
import java.util.*

data class AllVehicles(
    val currentTime: Long,
    val count: Int,
    val vehicles: List<Vehicle>
) : Serializable

data class Vehicle(
    val name: String,
    val model: String,
    val created: Date?,
    val edited: Date?,
    val cargoCapacity: String,
    val consumables: String,
    val costInCredits: String,
    val crew: String,
    val length: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val passengers: String,
    val vehicleClass: String,
    val filmsIds: List<Int>,
    val pilotsIds: List<Int>,
) : Serializable