package com.example.practiceapplication.Dagger

import com.example.practiceapplication.MainFeature.DrinksViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DrinksListModule {

    @Provides
    @FragmentScope
    fun getString(): String {
        return ("Test drink list view model factory")
    }

    @Provides
    @FragmentScope
    fun getDrinkListVmFactory(str: String): DrinksViewModelFactory {
        return DrinksViewModelFactory(str)
    }
}