package com.sdk.starwars.data.core.network

import com.sdk.starwars.data.core.Constants
import com.sdk.starwars.data.core.extension.toDate
import com.sdk.starwars.data.core.network.api.*
import com.sdk.starwars.domain.model.*
import java.util.*

internal fun List<String>.toFilmsList(): List<Films> {
    val list = mutableListOf<Films>()
    for (c in this) {
        list.add(Films(c))
    }
    return list
}

internal fun List<String>.toPeoplesList(): List<Peoples> {
    val list = mutableListOf<Peoples>()
    for (c in this) {
        list.add(Peoples(c))
    }
    return list
}

internal fun List<String>.toSpeciesList(): List<Species> {
    val list = mutableListOf<Species>()
    for (c in this) {
        list.add(Species(c))
    }
    return list
}

internal fun List<String>.toVehiclesList(): List<Vehicles> {
    val list = mutableListOf<Vehicles>()
    for (c in this) {
        list.add(Vehicles(c))
    }
    return list
}

internal fun List<String>.toStarshipsList(): List<Starships> {
    val list = mutableListOf<Starships>()
    for (c in this) {
        list.add(Starships(c))
    }
    return list
}

internal fun List<String>.toPlanetsList(): List<Planets> {
    val list = mutableListOf<Planets>()
    for (c in this) {
        list.add(Planets(c))
    }
    return list
}

internal fun Film.toDomain(): FilmsDto = FilmsDto(
    title = title,
    created = created.toDate(),
    director = director,
    edited = edited.toDate(),
    episodeId = episodeId,
    openingCrawl = openingCrawl,
    producer = producer,
    releaseDate = releaseDate.toDate(Constants.DATE_PATTERN_RELEASE_DATE),
    characters = characters.toPeoplesList(),
    species = species.toSpeciesList(),
    vehicles = vehicles.toVehiclesList(),
    starships = starships.toStarshipsList(),
    planets = planets.toPlanetsList(),
    url = url
)

internal fun List<Film>.toDomain(): List<FilmsDto> {
    val films = mutableListOf<FilmsDto>()
    for (film in this) {
        films.add(film.toDomain())
    }
    return films
}

internal fun GetAllFilmsResponse.toDomain(): AllFilmsDto {
    val currentTime = Calendar.getInstance().timeInMillis
    val films = if (count > 0) {
        results.toDomain()
    } else {
        emptyList()
    }

    return AllFilmsDto(
        currentTime = currentTime,
        count = count,
        films = films
    )
}

internal fun People.toDomain(): PeopleDto = PeopleDto(
    birthYear = birthYear,
    created = created.toDate(),
    edited = edited.toDate(),
    eyeColor = eyeColor,
    gender = gender,
    hairColor = hairColor,
    height = height,
    homeWorld = Planets(homeworld),
    mass = mass,
    name = name,
    skinColor = skinColor,
    films = films.toFilmsList(),
    species = species.toSpeciesList(),
    starships = starships.toStarshipsList(),
    vehicles = vehicles.toVehiclesList(),
    url = url
)

internal fun GetAllPeopleResponse.toDomain(): AllPeopleDto {
    val peoples = mutableListOf<PeopleDto>()
    val currentTime = Calendar.getInstance().timeInMillis
    if (count > 0) {
        for (people in results) {
            peoples.add(people.toDomain())
        }
    }

    return AllPeopleDto(
        currentTime = currentTime,
        count = count,
        peoples = peoples
    )
}


internal fun Vehicle.toDomain(): VehicleDto = VehicleDto(
    name = name,
    model = model,
    created = created.toDate(),
    edited = edited.toDate(),
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    crew = crew,
    length = length,
    manufacturer = manufacturer,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    passengers = passengers,
    vehicleClass = vehicleClass,
    films = films.toFilmsList(),
    pilots = pilots.toPeoplesList(),
    url = url,
)

internal fun GetAllVehiclesResponse.toDomain(): AllVehiclesDto {
    val vehicles = mutableListOf<VehicleDto>()
    val currentTime = Calendar.getInstance().timeInMillis
    if (count > 0) {
        for (vehicle in results) {
            vehicles.add(vehicle.toDomain())
        }
    }

    return AllVehiclesDto(
        currentTime = currentTime,
        count = count,
        vehicles = vehicles
    )
}

internal fun Specie.toDomain(): SpeciesDto = SpeciesDto(
    name = name,
    averageHeight = averageHeight,
    averageLifespan = averageLifespan,
    classification = classification,
    designation = designation,
    eyeColors = eyeColors,
    hairColors = hairColors,
    language = language,
    skinColors = skinColors,
    homeWorld = if (homeworld == null) null else Planets(homeworld),
    films = films.toFilmsList(),
    people = people.toPeoplesList(),
    created = created.toDate(),
    edited = edited.toDate(),
    url = url
)

internal fun GetAllSpeciesResponse.toDomain(): AllSpeciesDto {
    val species = mutableListOf<SpeciesDto>()
    val currentTime = Calendar.getInstance().timeInMillis
    if (count > 0) {
        for (specie in results) {
            species.add(specie.toDomain())
        }
    }

    return AllSpeciesDto(
        currentTime = currentTime,
        count = count,
        species = species
    )
}

internal fun Starship.toDomain(): StarshipDto = StarshipDto(
    name = name,
    model = model,
    passengers = passengers,
    cargoCapacity = cargoCapacity,
    consumables = consumables,
    costInCredits = costInCredits,
    created = created.toDate(),
    edited = edited.toDate(),
    crew = crew,
    hyperDriveRating = hyperdriveRating,
    length = length,
    mGLT = mGLT,
    manufacturer = manufacturer,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    films = films.toFilmsList(),
    pilots = pilots.toPeoplesList(),
    starshipClass = starshipClass,
    url = url
)

internal fun GetAllStarshipsResponse.toDomain(): AllStarshipsDto {
    val starships = mutableListOf<StarshipDto>()
    val currentTime = Calendar.getInstance().timeInMillis
    if (count > 0) {
        for (starship in results) {
            starships.add(starship.toDomain())
        }
    }

    return AllStarshipsDto(
        currentTime = currentTime,
        count = count,
        starships = starships
    )
}

internal fun Planet.toDomain(): PlanetDto = PlanetDto(
    climate = climate,
    created = created.toDate(),
    diameter = diameter,
    edited = edited.toDate(),
    gravity = gravity,
    name = name,
    orbitalPeriod = orbitalPeriod,
    population = population,
    rotationPeriod = rotationPeriod,
    surfaceWater = surfaceWater,
    terrain = terrain,
    films = films.toFilmsList(),
    residents = residents.toPeoplesList(),
    url = url
)

internal fun GetAllPlanetResponse.toDomain(): AllPlanetDto {
    val planets = mutableListOf<PlanetDto>()
    val currentTime = Calendar.getInstance().timeInMillis
    if (count > 0) {
        for (planet in results) {
            planets.add(planet.toDomain())
        }
    }

    return AllPlanetDto(
        currentTime = currentTime,
        count = count,
        planets = planets
    )
}