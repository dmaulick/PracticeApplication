package com.example.practiceapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.practiceapplication.NetworkingModule.DrinksApiSource
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult
import com.example.practiceapplication.TestHelpers.getOrAwaitValue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
//@RunWith(AndroidJUnit4::class)
class DrinksApiSourceTestLiveData {

    @get:Rule
    val rule = InstantTaskExecutorRule()

//    @Test
//    fun getDrinkById_LiveData() {
//
//        val drinkId = 17829
//
//        val drinkResultLiveData: MutableLiveData<WDrinkResult?> =
//            DrinksApiSource.getDrinkByIdLiveData(
//                drinkId
//            )
//
//        val drinkResult = drinkResultLiveData.getOrAwaitValue(10)
//
//        Assert.assertNotNull(drinkResult)
//        Assert.assertEquals(drinkResult!!.drinks.count(), 1)
//
//        val drink = drinkResult.drinks[0]
//
//        Assert.assertNotNull(drink)
//        Assert.assertEquals(drink.alcoholic, "Alcoholic")
//        Assert.assertEquals(drink.drinkCategory, "Cocktail")
//        Assert.assertEquals(drink.drinkId, "17829")
//        Assert.assertEquals(drink.drinkName, "Penicillin")
//        Assert.assertEquals(
//            drink.instructions,
//            "Shake blended Scotch, lemon juice, honey syrup and ginger syrup with ice. Strain over large ice in chilled rocks glass. Float smoky Scotch on top (be sure to use a smoky Scotch such as an Islay single malt). Garnish with candied ginger."
//        )
//
//
//    }

}