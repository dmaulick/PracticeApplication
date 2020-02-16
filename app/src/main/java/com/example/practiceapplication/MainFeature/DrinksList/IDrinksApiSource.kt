package com.example.practiceapplication.MainFeature.DrinksList

import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult

interface IDrinksApiSource {
    suspend fun getRandomDrinkCoroutines(): WDrinkResult
    suspend fun getDrinkByIdCoroutine(drinkId: Int): WDrinkResult
}