package com.sdk.starwars.presentation.core.extensions

import com.sdk.starwars.domain.model.*
import com.sdk.starwars.presentation.core.model.*
import com.sdk.starwars.presentation.core.model.Species

fun <R> Result<R>.toResponse(): Response<R> {
    return when (this) {
        is Result.Success -> Response.Success(this.data)
        is Result.Error -> Response.Error(this.exception)
    }
}

fun <T : Link> List<T>.toIds(): List<Int> {
    val list = mutableListOf<Int>()
    for (c in this) {
        list.add(c.getId())
    }
    return list
}

internal fun AllFilmsDto.toResponse(): AllFilms = AllFilms(
    currentTime = currentTime,
    count = count,
    films = films.toFilmResponse()
)

internal fun List<FilmsDto>.toFilmResponse(): List<Film> {
    val result = mutableListOf<Film>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun FilmsDto.toResponse(): Film = Film(
    title = title,
    created = created,
    director = director,
    edited = edited,
    episodeId = episodeId,
    openingCrawl = openingCrawl,
    producer = producer,
    releaseDate = releaseDate,
    charactersIds = characters?.toIds() ?: emptyList(),
    speciesIds = species?.toIds() ?: emptyList(),
    vehiclesIds = vehicles?.toIds() ?: emptyList(),
    starshipsIds = starships?.toIds() ?: emptyList(),
    planetsIds = planets?.toIds() ?: emptyList()
)

internal fun AllPeopleDto.toResponse(): AllPeople = AllPeople(
    currentTime = currentTime,
    count = count,
    people = peoples.toPeopleResponse()
)

internal fun List<PeopleDto>.toPeopleResponse(): List<People> {
    val result = mutableListOf<People>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun PeopleDto.toResponse(): People = People(
    name = name,
    birthYear = birthYear,
    created = created,
    edited = edited,
    eyeColor = eyeColor,
    gender = gender,
    hairColor = hairColor,
    height = height,
    homeWorldId = homeWorld?.getId(),
    mass = mass,
    skinColor = skinColor,
    filmsIds = films?.toIds() ?: emptyList(),
    speciesIds = species?.toIds() ?: emptyList(),
    starshipsIds = starships?.toIds() ?: emptyList(),
    vehiclesIds = vehicles?.toIds() ?: emptyList(),
)


internal fun AllPlanetDto.toResponse(): AllPlanet = AllPlanet(
    currentTime = currentTime,
    count = count,
    planets = planets.toPlanetsResponse()
)

internal fun List<PlanetDto>.toPlanetsResponse(): List<Planet> {
    val result = mutableListOf<Planet>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun PlanetDto.toResponse(): Planet = Planet(
    name = name,
    climate = climate,
    diameter = diameter,
    created = created,
    edited = edited,
    gravity = gravity,
    orbitalPeriod = orbitalPeriod,
    population = population,
    rotationPeriod = rotationPeriod,
    surfaceWater = surfaceWater,
    terrain = terrain,
    filmsIds = films?.toIds() ?: emptyList(),
    residentsIds = residents?.toIds() ?: emptyList()
)

internal fun AllSpeciesDto.toResponse(): AllSpecies = AllSpecies(
    currentTime = currentTime,
    count = count,
    species = species.toSpeciesResponse()
)

internal fun List<SpeciesDto>.toSpeciesResponse(): List<Species> {
    val result = mutableListOf<Species>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun SpeciesDto.toResponse(): Species = Species(
    name = name,
    averageHeight = averageHeight,
    averageLifespan = averageLifespan,
    classification = classification,
    designation = designation,
    eyeColors = eyeColors,
    hairColors = hairColors,
    language = language,
    skinColors = skinColors,
    homeWorldId = homeWorld?.getId(),
    filmsIds = films?.toIds() ?: emptyList(),
    peopleIds = people?.toIds() ?: emptyList(),
    created = created,
    edited = edited
)

internal fun AllStarshipsDto.toResponse(): AllStarships = AllStarships(
    currentTime = currentTime,
    count = count,
    starships = starships.toStarshipsResponse()
)

internal fun List<StarshipDto>.toStarshipsResponse(): List<Starship> {
    val result = mutableListOf<Starship>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun StarshipDto.toResponse(): Starship = Starship(
    name = name,
    model = model,
    passengers = passengers,
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    created = created,
    edited = edited,
    crew = crew,
    hyperDriveRating = hyperDriveRating,
    length = length,
    mGLT = mGLT,
    manufacturer = manufacturer,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    starshipClass = starshipClass,
    filmsIds = films?.toIds() ?: emptyList(),
    pilotsIds = pilots?.toIds() ?: emptyList()
)

internal fun AllVehiclesDto.toResponse(): AllVehicles = AllVehicles(
    currentTime = currentTime,
    count = count,
    vehicles = vehicles.toVehicleResponse()
)

internal fun List<VehicleDto>.toVehicleResponse(): List<Vehicle> {
    val result = mutableListOf<Vehicle>()
    for (f in this) {
        result.add(f.toResponse())
    }
    return result
}

internal fun VehicleDto.toResponse(): Vehicle = Vehicle(
    name = name,
    model = model,
    created = created,
    edited = edited,
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    crew = crew,
    length = length,
    manufacturer = manufacturer,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    passengers = passengers,
    vehicleClass = vehicleClass,
    filmsIds = films?.toIds() ?: emptyList(),
    pilotsIds = pilots?.toIds() ?: emptyList()
)