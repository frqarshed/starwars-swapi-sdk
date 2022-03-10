package com.sdk.starwars

import android.app.Application
import com.sdk.starwars.presentation.core.main.StarWarsController

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        StarWarsController.initializeSDK(this)
    }
}