package com.example.practiceapplication.NetworkingModule

import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksApiInterface {

    @GET("/random.php")
    suspend fun getRandromDrinkCoroutines(): WDrinkResult


    @GET("/random.php")
    fun getRandromDrinkLiveData(): Call<WDrinkResult>

    @GET("/lookup.php")
    suspend fun getDrinkByIdCoroutine(@Query("i") drinkId: Int): WDrinkResult

    @GET("/lookup.php")
    fun getDrinkByIdLiveData(@Query("i") drinkId: Int): Call<WDrinkResult>

}