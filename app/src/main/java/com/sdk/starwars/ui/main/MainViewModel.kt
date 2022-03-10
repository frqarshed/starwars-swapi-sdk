package com.sdk.starwars.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.starwars.presentation.core.main.StarWarsController
import com.sdk.starwars.presentation.core.model.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val controller = StarWarsController()
    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        buttonClicked()
    }

    fun buttonClicked() {
        viewModelScope.launch {
            getAllVehicles()
//            getAllStarships()
//            getAllSpecies()
//            getAllPeoples()
//            getAllFilms()
//            getAllPlanets()
//
//            getVehiclesById(1)
//            getVehiclesById(14)

//            getStarshipById(1)
//            getStarshipById(12)

//            getSpeciesById(0)
//            getSpeciesById(1)

//            getPeopleById(0)
//            getPeopleById(1)

//            getFilmById(0)
//            getFilmById(1)

//            getPlanetById(0)
//            getPlanetById(1)
//

//            searchVehiclesByName("")
//            searchVehiclesByName("asd123")
//            searchVehiclesByName("Crawler")
//
//            searchFilmByTitle("")
//            searchFilmByTitle("asd123")
//            searchFilmByTitle("")
//
//
//            searchPeopleByName("")
//            searchPeopleByName("asd123")
//            searchPeopleByName("Luke")

//            searchPlanetByName("")
//            searchPlanetByName("asd123")
//            searchPlanetByName("Tatooine")
//
//            searchSpeciesByName("")
//            searchSpeciesByName("asd123")
//            searchSpeciesByName("Human")
//
//            searchStarshipByName("")
//            searchStarshipByName("asd123")
//            searchStarshipByName("corvette")
        }
    }

    private suspend fun getAllVehicles() {
        when (val result = controller.getAllVehicles(1)) {
            is Response.Success<AllVehicles> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.vehicles[0].name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getAllStarships() {
        when (val result = controller.getAllStarships(1)) {
            is Response.Success<AllStarships> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.starships[0].name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getAllSpecies() {
        when (val result = controller.getAllSpecies(1)) {
            is Response.Success<AllSpecies> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.species[0].name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getAllPeoples() {
        when (val result = controller.getAllPeoples(1)) {
            is Response.Success<AllPeople> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.people[0].name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getAllPlanets() {
        when (val result = controller.getAllPlanets(1)) {
            is Response.Success<AllPlanet> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.planets[0].name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getAllFilms() {
        when (val result = controller.getAllFilms(pageNumber = 1)) {
            is Response.Success<AllFilms> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.films[0].title}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }


    private suspend fun getVehiclesById(id: Int) {
        when (val result = controller.getVehiclesById(id)) {
            is Response.Success<Vehicle> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getStarshipById(id: Int) {
        when (val result = controller.getStarshipById(id)) {
            is Response.Success<Starship> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getSpeciesById(id: Int) {
        when (val result = controller.getSpeciesById(id)) {
            is Response.Success<Species> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getPeopleById(id: Int) {
        when (val result = controller.getPeopleById(id)) {
            is Response.Success<People> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getPlanetById(id: Int) {
        when (val result = controller.getPlanetById(id)) {
            is Response.Success<Planet> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.name}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun getFilmById(id: Int) {
        when (val result = controller.getFilmById(id)) {
            is Response.Success<Film> -> {
                val searchResult = result.data
                message.postValue("Hello From Button ${searchResult.title}")

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }


    private suspend fun searchVehiclesByName(text: String) {
        when (val result = controller.searchVehiclesByName(text)) {
            is Response.Success<AllVehicles> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.vehicles[0].name}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun searchStarshipByName(text: String) {
        when (val result = controller.searchStarshipByName(text)) {
            is Response.Success<AllStarships> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.starships[0].name}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun searchSpeciesByName(text: String) {
        when (val result = controller.searchSpeciesByName(text)) {
            is Response.Success<AllSpecies> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.species[0].name}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun searchPeopleByName(text: String) {
        when (val result = controller.searchPeopleByName(text)) {
            is Response.Success<AllPeople> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.people[0].name}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun searchPlanetByName(text: String) {
        when (val result = controller.searchPlanetByName(text)) {
            is Response.Success<AllPlanet> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.planets[0].name}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

    private suspend fun searchFilmByTitle(text: String) {
        when (val result = controller.searchFilmByTitle(text)) {
            is Response.Success<AllFilms> -> {
                val searchResult = result.data
                if (searchResult.count > 0) {
                    message.postValue("Hello From Button ${searchResult.films[0].title}")
                } else {
                    message.postValue("Hello From Button No result found")
                }

            }
            is Response.Error -> {
                message.postValue("Hello From Button ${result.getException().response}")
            }
        }
    }

}