package com.example.practiceapplication

import androidx.test.platform.app.InstrumentationRegistry
import com.example.practiceapplication.NetworkingModule.DrinksApiSource
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult
import com.example.practiceapplication.Utils.ContextUtils.StringContext
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DrinksApiSourceTest {

    @Test
    fun randomDrinkCall_UsingCoroutines() {

        val stringContext = StringContext(
            InstrumentationRegistry.getInstrumentation().targetContext
        )

        val drinkResult: WDrinkResult = runBlocking {
            DrinksApiSource.getInstance(stringContext).getRandomDrinkCoroutines()
        }

        assertNotNull(drinkResult)
        assertEquals(drinkResult.drinks.count(), 1)

        val drink = drinkResult.drinks[0]

        assertNotNull(drink)
        assertNotNull(drink.alcoholic)
        assertNotNull(drink.drinkCategory)
        assertNotNull(drink.drinkId)
        assertNotNull(drink.drinkName)
        assertNotNull(drink.instructions)


    }

    @Test
    fun getDrinkById_UsingCoroutines() {

        val drinkId = 17829

        val stringContext = StringContext(
            InstrumentationRegistry.getInstrumentation().targetContext
        )

        val drinkResult: WDrinkResult = runBlocking {
            DrinksApiSource.getInstance(stringContext).getDrinkByIdCoroutine(
                drinkId
            )
        }

        assertNotNull(drinkResult)
        assertEquals(drinkResult.drinks.count(), 1)

        val drink = drinkResult.drinks[0]
        assertNotNull(drink)
        assertEquals(drink.alcoholic, "Alcoholic")
        assertEquals(drink.drinkCategory, "Cocktail")
        assertEquals(drink.drinkId, "17829")
        assertEquals(drink.drinkName, "Penicillin")
        assertEquals(drink.instructions, "Shake blended Scotch, lemon juice, honey syrup and ginger syrup with ice. Strain over large ice in chilled rocks glass. Float smoky Scotch on top (be sure to use a smoky Scotch such as an Islay single malt). Garnish with candied ginger.")


    }

}