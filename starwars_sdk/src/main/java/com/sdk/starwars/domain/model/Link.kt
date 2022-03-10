package com.sdk.starwars.domain.model

internal data class Films(val url: String) : Link(url) {
    override fun getType(): String = FILMS
}

internal data class Peoples(val url: String) : Link(url) {
    override fun getType(): String = PEOPLE
}

internal data class Species(val url: String) : Link(url) {
    override fun getType(): String = SPECIES
}

internal data class Vehicles(val url: String) : Link(url) {
    override fun getType(): String = VEHICLES
}

internal data class Starships(val url: String) : Link(url) {
    override fun getType(): String = STARSHIPS
}

internal data class Planets(val url: String) : Link(url) {
    override fun getType(): String = PLANETS
}

internal abstract class Link(private val link: String) {
    abstract fun getType(): String

    fun getId(): Int {
        return link.removePrefix("https://swapi.dev/api/${getType()}/").removeSuffix("/").toInt()
    }
}

internal const val FILMS = "films"
internal const val PEOPLE = "people"
internal const val PLANETS = "planets"
internal const val SPECIES = "species"
internal const val STARSHIPS = "starships"
internal const val VEHICLES = "vehicles"