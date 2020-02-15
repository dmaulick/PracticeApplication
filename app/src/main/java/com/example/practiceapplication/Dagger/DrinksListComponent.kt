package com.example.practiceapplication.Dagger

import com.example.practiceapplication.MainFeature.DrinksList.DrinkListFragment
import dagger.Component
import javax.inject.Singleton

@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [DrinksListModule::class])
interface DrinksListComponent {
    fun inject(drinksListFragment: DrinkListFragment)
}