package com.example.practiceapplication

import android.app.Application
import android.content.Context
import com.example.practiceapplication.Dagger.AppComponent
import com.example.practiceapplication.Dagger.AppModule
import com.example.practiceapplication.Dagger.DaggerAppComponent
import timber.log.Timber

class PracticeApp : Application() {

    companion object {
        lateinit var appContext: Context
    }


    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        Timber.plant(Timber.DebugTree())
    }

}