package com.lucas.movies

import android.app.Application
import com.lucas.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            loadKoinModules(
                networkModule
            )
        }
    }
}