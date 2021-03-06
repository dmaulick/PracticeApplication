package com.example.practiceapplication.MainFeature.DrinksList

import com.example.practiceapplication.Database.DrinkDao
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DrinksListRepository private constructor(private val drinksApiSource: IDrinksApiSource,
                                               private val drinkDao: DrinkDao): IDrinksListRepository {

    override suspend fun getExpectedListOfDrinks(): List<WDrinkModel> {

        val expectedDrinkList = arrayListOf<WDrinkModel>()

        for (i in 17829 until 17833) {
            val drinkResult = drinksApiSource.getDrinkByIdCoroutine(i)
            val drink = drinkResult.drinks[0]
            expectedDrinkList.add(drink)
        }

        return expectedDrinkList
    }

    override suspend fun getRandomListOfDrinks(): List<WDrinkModel> {

        val randomDrinkList = arrayListOf<WDrinkModel>()

        for (i in 0 until 15) {
            val drinkResult = drinksApiSource.getRandomDrinkCoroutines()
            val drink = drinkResult.drinks[0]
            randomDrinkList.add(drink)
        }

        return randomDrinkList
    }


    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: DrinksListRepository? = null

        fun getInstance(drinksApiSource: IDrinksApiSource, drinkDao: DrinkDao) =
            instance ?: synchronized(this) {
                instance ?: DrinksListRepository(drinksApiSource, drinkDao).also { instance = it }
            }

    }
}