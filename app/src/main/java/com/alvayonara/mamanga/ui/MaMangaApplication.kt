package com.alvayonara.mamanga.ui

import android.app.Application
import com.alvayonara.mamanga.BuildConfig
import timber.log.Timber

class MaMangaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}