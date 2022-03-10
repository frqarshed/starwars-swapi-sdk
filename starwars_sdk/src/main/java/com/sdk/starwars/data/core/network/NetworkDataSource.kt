package com.sdk.starwars.data.core.network

import com.sdk.starwars.data.core.network.api.*
import retrofit2.Retrofit


internal open class NetworkDataSource(
    retrofitClient: Retrofit
) :
    FilmsApi,
    PeopleApi,
    PlanetApi,
    StarshipsApi,
    SpeciesApi,
    VehiclesApi {

    private val filmsApi = retrofitClient.create(FilmsApi::class.java)
    private val peopleApi = retrofitClient.create(PeopleApi::class.java)
    private val planetApi = retrofitClient.create(PlanetApi::class.java)
    private val speciesApi = retrofitClient.create(SpeciesApi::class.java)
    private val starshipsApi = retrofitClient.create(StarshipsApi::class.java)
    private val vehiclesApi = retrofitClient.create(VehiclesApi::class.java)

    // Films Api
    override suspend fun getAllFilms(pageNumber: Int): GetAllFilmsResponse =
        filmsApi.getAllFilms(pageNumber)

    override suspend fun getFilm(id: Int): Film =
        filmsApi.getFilm(id)

    override suspend fun searchFilmWithTitle(title: String): GetAllFilmsResponse =
        filmsApi.searchFilmWithTitle(title)

    // People Api
    override suspend fun getAllPeople(pageNumber: Int): GetAllPeopleResponse =
        peopleApi.getAllPeople(pageNumber)

    override suspend fun getPeople(id: Int): People =
        peopleApi.getPeople(id)

    override suspend fun searchPeopleWithName(name: String): GetAllPeopleResponse =
        peopleApi.searchPeopleWithName(name)

    // Planet Api
    override suspend fun getAllPlanet(pageNumber: Int): GetAllPlanetResponse =
        planetApi.getAllPlanet(pageNumber)

    override suspend fun getPlanet(id: Int): Planet =
        planetApi.getPlanet(id)

    override suspend fun searchPlanetWithName(name: String): GetAllPlanetResponse =
        planetApi.searchPlanetWithName(name)

    // Species Api
    override suspend fun getAllSpecies(pageNumber: Int): GetAllSpeciesResponse =
        speciesApi.getAllSpecies(pageNumber)

    override suspend fun getSpecies(id: Int): Specie =
        speciesApi.getSpecies(id)

    override suspend fun searchSpeciesWithName(name: String): GetAllSpeciesResponse =
        speciesApi.searchSpeciesWithName(name)

    // Starships Api
    override suspend fun getAllStarships(pageNumber: Int): GetAllStarshipsResponse =
        starshipsApi.getAllStarships(pageNumber)

    override suspend fun getStarships(id: Int): Starship =
        starshipsApi.getStarships(id)

    override suspend fun searchStarships(nameOrModel: String): GetAllStarshipsResponse =
        starshipsApi.searchStarships(nameOrModel)

    // Vehicle Api
    override suspend fun getAllVehicles(pageNumber: Int): GetAllVehiclesResponse =
        vehiclesApi.getAllVehicles(pageNumber)

    override suspend fun getVehicles(id: Int): Vehicle =
        vehiclesApi.getVehicles(id)

    override suspend fun searchVehicles(nameOrModel: String): GetAllVehiclesResponse =
        call(vehiclesApi.searchVehicles(nameOrModel))

    private fun <T : Response> call(response: T): T {
        return response
//            .flatMap {
//                when {
//                    it.code == null || it.isSuccessful -> Observable.just(it)
//                    else -> {
//                        handleFailure(it)
//                    }
//                }
//            }
//            .doOnError {
//                doOnError(it)
//            }
    }
}