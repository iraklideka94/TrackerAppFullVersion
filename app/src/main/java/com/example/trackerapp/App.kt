package com.example.trackerapp

import android.app.Application
import com.example.trackerapp.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(coreModule)
        }
    }
}