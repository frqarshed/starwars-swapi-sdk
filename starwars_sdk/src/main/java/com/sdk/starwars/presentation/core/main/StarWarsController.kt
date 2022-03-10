package com.sdk.starwars.presentation.core.main

import android.content.Context
import com.sdk.starwars.presentation.core.di.*
import com.sdk.starwars.presentation.core.model.*
import javax.inject.Inject

internal object DaggerInitializer {
    private lateinit var appComponent: AppComponent

    fun initializeDagger(context: Context) {
        appComponent =
            DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .appModule(AppModule(context))
                .build()
    }

    internal fun getAppComponent() = appComponent
}

class StarWarsController {

    init {
        DaggerInitializer.getAppComponent().inject(this)
    }

    @Inject
    internal lateinit var presenter: StarWarsPresenter

    suspend fun getAllFilms(pageNumber: Int): Response<AllFilms> =
        presenter.getAllFilms(pageNumber)

    suspend fun getAllPeoples(pageNumber: Int): Response<AllPeople> =
        presenter.getAllPeoples(pageNumber)

    suspend fun getAllPlanets(pageNumber: Int): Response<AllPlanet> =
        presenter.getAllPlanets(pageNumber)

    suspend fun getAllSpecies(pageNumber: Int): Response<AllSpecies> =
        presenter.getAllSpecies(pageNumber)

    suspend fun getAllStarships(pageNumber: Int): Response<AllStarships> =
        presenter.getAllStarships(pageNumber)

    suspend fun getAllVehicles(pageNumber: Int): Response<AllVehicles> =
        presenter.getAllVehicles(pageNumber)

    suspend fun getFilmById(filmId: Int): Response<Film> =
        presenter.getFilmById(filmId)

    suspend fun getPeopleById(peopleId: Int): Response<People> =
        presenter.getPeopleById(peopleId)

    suspend fun getPlanetById(planetId: Int): Response<Planet> =
        presenter.getPlanetById(planetId)

    suspend fun getSpeciesById(speciesId: Int): Response<Species> =
        presenter.getSpeciesById(speciesId)

    suspend fun getStarshipById(starshipId: Int): Response<Starship> =
        presenter.getStarshipById(starshipId)

    suspend fun getVehiclesById(vehicleId: Int): Response<Vehicle> =
        presenter.getVehiclesById(vehicleId)

    suspend fun searchFilmByTitle(title: String): Response<AllFilms> =
        presenter.searchFilmByTitle(title)

    suspend fun searchPeopleByName(name: String): Response<AllPeople> =
        presenter.searchPeopleByName(name)

    suspend fun searchPlanetByName(name: String): Response<AllPlanet> =
        presenter.searchPlanetByName(name)

    suspend fun searchSpeciesByName(name: String): Response<AllSpecies> =
        presenter.searchSpeciesByName(name)

    suspend fun searchStarshipByName(name: String): Response<AllStarships> =
        presenter.searchStarshipByName(name)

    suspend fun searchStarshipByModel(model: String): Response<AllStarships> =
        presenter.searchStarshipByModel(model)

    suspend fun searchVehiclesByName(name: String): Response<AllVehicles> =
        presenter.searchVehiclesByName(name)

    suspend fun searchVehiclesByModel(model: String): Response<AllVehicles> =
        presenter.searchVehiclesByModel(model)

    companion object {
        fun initializeSDK(context: Context) {
            DaggerInitializer.initializeDagger(context)
        }
    }
}