package com.example.practiceapplication.MainFeature.DrinksList

import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel

interface IDrinksListRepository {
    suspend fun getExpectedListOfDrinks(): List<WDrinkModel>
    suspend fun getRandomListOfDrinks(): List<WDrinkModel>
}