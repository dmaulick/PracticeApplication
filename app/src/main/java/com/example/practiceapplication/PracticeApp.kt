package com.example.practiceapplication

import android.app.Application
import com.example.practiceapplication.Dagger.AppComponent
import com.example.practiceapplication.Dagger.AppModule
import com.example.practiceapplication.Dagger.DaggerAppComponent

class PracticeApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}