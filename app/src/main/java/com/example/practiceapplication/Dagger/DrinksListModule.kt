package com.example.practiceapplication.Dagger

import android.content.Context
import com.example.practiceapplication.Database.DrinkDao
import com.example.practiceapplication.Database.DrinkDatabase
import com.example.practiceapplication.MainFeature.DrinksList.DrinksListRepository
import com.example.practiceapplication.MainFeature.DrinksList.IDrinksApiSource
import com.example.practiceapplication.MainFeature.DrinksList.IDrinksListRepository
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
    fun getDrinksDao(context: Context): DrinkDao {
        return DrinkDatabase.getInstance(context).drinkDao()
    }


    @Provides
    @FragmentScope
    fun getDrinksListRepository(drinksApiSource: IDrinksApiSource, drinkDao: DrinkDao): IDrinksListRepository {
        return DrinksListRepository.getInstance(drinksApiSource, drinkDao)
    }


    @Provides
    @FragmentScope
    fun getDrinkListVmFactory(drinksListRepository: IDrinksListRepository): DrinksViewModelFactory {
        return DrinksViewModelFactory(drinksListRepository)
    }
}