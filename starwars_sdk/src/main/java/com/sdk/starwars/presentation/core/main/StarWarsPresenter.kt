package com.sdk.starwars.presentation.core.main

import com.sdk.starwars.domain.interactor.usecase.*
import com.sdk.starwars.domain.model.*
import com.sdk.starwars.presentation.core.extensions.toResponse
import com.sdk.starwars.presentation.core.model.*
import com.sdk.starwars.presentation.core.model.Species
import javax.inject.Inject


internal class StarWarsPresenter @Inject constructor(
    private var getAllFilmsUseCase: GetAllFilmsUseCase,
    private var getAllPeopleUseCase: GetAllPeopleUseCase,
    private var getAllPlanetsUseCase: GetAllPlanetsUseCase,
    private var getAllSpeciesUseCase: GetAllSpeciesUseCase,
    private var getAllStarshipsUseCase: GetAllStarshipsUseCase,
    private var getAllVehiclesUseCase: GetAllVehiclesUseCase,
    private var getFilmUseCase: GetFilmUseCase,
    private var getPeopleUseCase: GetPeopleUseCase,
    private var getPlanetUseCase: GetPlanetUseCase,
    private var getSpecieUseCase: GetSpecieUseCase,
    private var getStarshipUseCase: GetStarshipUseCase,
    private var getVehicleUseCase: GetVehicleUseCase,
    private var searchFilmUseCase: SearchFilmUseCase,
    private var searchPeopleUseCase: SearchPeopleUseCase,
    private var searchPlanetUseCase: SearchPlanetUseCase,
    private var searchSpecieUseCase: SearchSpecieUseCase,
    private var searchStarshipByModelUseCase: SearchStarshipByModelUseCase,
    private var searchStarshipByNameUseCase: SearchStarshipByNameUseCase,
    private var searchVehicleByModelUseCase: SearchVehicleByModelUseCase,
    private var searchVehicleByNameUseCase: SearchVehicleByNameUseCase,
) {

    suspend fun getAllFilms(pageNumber: Int): Response<AllFilms> =

        when (val result = getAllFilmsUseCase.execute(GetAllFilmsUseCase.Params(pageNumber))) {
            is Result.Success<AllFilmsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getFilmById(filmId: Int): Response<Film> =
        when (val result = getFilmUseCase.execute(GetFilmUseCase.Params(filmId))) {
            is Result.Success<FilmsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchFilmByTitle(title: String): Response<AllFilms> =
        when (val result = searchFilmUseCase.execute(SearchFilmUseCase.Params(title))) {
            is Result.Success<AllFilmsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getAllPeoples(pageNumber: Int): Response<AllPeople> =
        when (val result = getAllPeopleUseCase.execute(GetAllPeopleUseCase.Params(pageNumber))) {
            is Result.Success<AllPeopleDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getPeopleById(peopleId: Int): Response<People> =
        when (val result = getPeopleUseCase.execute(GetPeopleUseCase.Params(peopleId))) {
            is Result.Success<PeopleDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchPeopleByName(name: String): Response<AllPeople> =
        when (val result = searchPeopleUseCase.execute(SearchPeopleUseCase.Params(name))) {
            is Result.Success<AllPeopleDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getAllPlanets(pageNumber: Int): Response<AllPlanet> =
        when (val result = getAllPlanetsUseCase.execute(GetAllPlanetsUseCase.Params(pageNumber))) {
            is Result.Success<AllPlanetDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getPlanetById(planetId: Int): Response<Planet> =
        when (val result = getPlanetUseCase.execute(GetPlanetUseCase.Params(planetId))) {
            is Result.Success<PlanetDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchPlanetByName(name: String): Response<AllPlanet> =
        when (val result = searchPlanetUseCase.execute(SearchPlanetUseCase.Params(name))) {
            is Result.Success<AllPlanetDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getAllSpecies(pageNumber: Int): Response<AllSpecies> =
        when (val result = getAllSpeciesUseCase.execute(GetAllSpeciesUseCase.Params(pageNumber))) {
            is Result.Success<AllSpeciesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getSpeciesById(speciesId: Int): Response<Species> =
        when (val result = getSpecieUseCase.execute(GetSpecieUseCase.Params(speciesId))) {
            is Result.Success<SpeciesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchSpeciesByName(name: String): Response<AllSpecies> =
        when (val result = searchSpecieUseCase.execute(SearchSpecieUseCase.Params(name))) {
            is Result.Success<AllSpeciesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getAllStarships(pageNumber: Int): Response<AllStarships> =
        when (val result =
            getAllStarshipsUseCase.execute(GetAllStarshipsUseCase.Params(pageNumber))) {
            is Result.Success<AllStarshipsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getStarshipById(starshipId: Int): Response<Starship> =
        when (val result = getStarshipUseCase.execute(GetStarshipUseCase.Params(starshipId))) {
            is Result.Success<StarshipDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchStarshipByName(name: String): Response<AllStarships> =
        when (val result =
            searchStarshipByNameUseCase.execute(SearchStarshipByNameUseCase.Params(name))) {
            is Result.Success<AllStarshipsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchStarshipByModel(model: String): Response<AllStarships> =
        when (val result =
            searchStarshipByModelUseCase.execute(SearchStarshipByModelUseCase.Params(model))) {
            is Result.Success<AllStarshipsDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getAllVehicles(pageNumber: Int): Response<AllVehicles> =
        when (val result =
            getAllVehiclesUseCase.execute(GetAllVehiclesUseCase.Params(pageNumber))) {
            is Result.Success<AllVehiclesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun getVehiclesById(vehicleId: Int): Response<Vehicle> =
        when (val result = getVehicleUseCase.execute(GetVehicleUseCase.Params(vehicleId))) {
            is Result.Success<VehicleDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchVehiclesByName(name: String): Response<AllVehicles> =
        when (val result =
            searchVehicleByNameUseCase.execute(SearchVehicleByNameUseCase.Params(name))) {
            is Result.Success<AllVehiclesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }

    suspend fun searchVehiclesByModel(model: String): Response<AllVehicles> =
        when (val result =
            searchVehicleByModelUseCase.execute(SearchVehicleByModelUseCase.Params(model))) {
            is Result.Success<AllVehiclesDto> -> {
                Response.Success(result.data.toResponse())
            }
            is Result.Error -> {
                Response.Error(exception = result.exception)
            }
        }
}