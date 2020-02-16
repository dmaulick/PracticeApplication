package com.example.practiceapplication.MockTests

import com.example.practiceapplication.Database.DrinkDao
import com.example.practiceapplication.MainFeature.DrinksList.DrinksListRepository
import com.example.practiceapplication.MainFeature.DrinksList.IDrinksApiSource
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner

@RunWith(MockitoJUnitRunner::class)
class DrinkRepoTest {

    private val mockDrinksApi = mock<IDrinksApiSource>()

    @Mock
    private lateinit var mockDrinkDao: DrinkDao



    // Directory for good documentation:
    // https://site.mockito.org  -> then go to more section

    // when
    // https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#when-T-


    // These do not work but the general idea for mockito is here
    // There are issues with mockito and coroutines
    // This is where Mockk probably comes in handy
    @Ignore
    @Test
    fun test1() = runBlocking {

        whenever (mockDrinksApi.getDrinkByIdCoroutine(ArgumentMatchers.anyInt())).thenReturn(
            WDrinkResult(listOf(WDrinkModel("dI", "dn", "dc", "da", "dinstruct")))
        )

        `when`(mockDrinksApi.getRandomDrinkCoroutines()).thenReturn(
            WDrinkResult(listOf(WDrinkModel("r_dI", "r_dn", "r_dc", "r_da", "r_dinstruct")))
        )

        val drinksRepo = DrinksListRepository.getInstance(mockDrinksApi, mockDrinkDao)

        val result = drinksRepo.getExpectedListOfDrinks()

        Assert.assertEquals(result.count(), 1)

    }
}