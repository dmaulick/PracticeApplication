package com.example.practiceapplication.Dagger

import android.content.Context
import com.example.practiceapplication.MainFeature.DrinksList.DrinkListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
}


// This is a good resource for subcomponents
// https://stackoverflow.com/questions/37434657/cannot-be-provided-without-an-inject-constructor-or-from-an-provides-annotated