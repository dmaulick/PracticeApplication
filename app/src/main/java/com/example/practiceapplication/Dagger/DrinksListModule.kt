package com.example.practiceapplication.Dagger

import android.content.Context
import com.example.practiceapplication.MainFeature.DrinksList.IDrinksApiSource
import com.example.practiceapplication.MainFeature.DrinksViewModelFactory
import com.example.practiceapplication.NetworkingModule.DrinksApiSource
import dagger.Module
import dagger.Provides

@Module
class DrinksListModule(private val context: Context) {

    @Provides
    @FragmentScope
    fun getContext(): Context = context


    @Provides
    @FragmentScope
    fun getDrinksApiSource(context: Context): IDrinksApiSource {
        return DrinksApiSource.getInstance(context)
    }

    @Provides
    @FragmentScope
    fun getDrinkListVmFactory(drinksApiSource: IDrinksApiSource): DrinksViewModelFactory {
        return DrinksViewModelFactory(drinksApiSource)
    }
}