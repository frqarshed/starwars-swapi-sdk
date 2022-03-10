package com.sdk.starwars.domain.model

import java.io.Serializable
import java.util.*

internal data class AllVehiclesDto(
    val currentTime: Long,
    val count: Int,
    val vehicles: List<VehicleDto>
) : Serializable

internal data class VehicleDto(
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
    val films: List<Films>?,
    val pilots: List<Peoples>?,
    private val url: String,
) : Serializable, Link(url) {
    override fun getType(): String = VEHICLES
}