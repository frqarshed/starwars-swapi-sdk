![min Android SDK version is 21](https://img.shields.io/badge/min%20Android%20SDK-21-green)

# StarWars Swapi Android SDK

This is the implementation of StarWars API provided by [Swapi](https://swapi.dev/) for Android.

## SDK Features

The SDK Features support for all the APIs provided by Swapi. Fetching all information, fetching
particular object details by id and search by name or model as available in the APIs are made
available through the SDK.

## Getting Started

The SDK supports Kotlin Language and is written to
support [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) only.

## Install the SDK

To install the SDK copy the AAR file `(final_output/release/starwars_sdk.aar)` from the root
directory to the `libs` directory of your module and add the dependency in `build.gradle` file of
the module.

```groovy
dependencies {
    implementation fileTree(dir: 'libs', include: ['starwars_sdk.aar'])
    ...
}
```

## Initialize the SDK

Before you can use the SDK, you need to initialize it in the Application class. `StarWarsController`
exposes a static function `initializeSDK` which configures the SDK once.

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        StarWarsController.initializeSDK(this)
    }
}
```

To access the SDK methods you need to create a `StarWarsController` instance and then call the
desired methods. Make sure to call the methods of the controller from a coroutine.

```kotlin
val controller = StarWarsController()
controller.getAllFilms(pageNumber = 1)
```

# Future Work

Future work includes SDKs with `RxKotlin` and simple `Callbacks` to cover most of the common
implementations.

# Known Bug

- [ ] Next Page and Previous page information is not available when the client will try to fetch the
  list of Movies, People, Species, Starships, Planets, and Vehicles.

# More information

Complete SDK documentation is not yet available and work is in progress.
