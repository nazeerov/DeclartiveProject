package com.nazirov.declerativeproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class DeclarativeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}