package com.app.stationaryapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class StationaryApplication : Application()/*{

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}*/