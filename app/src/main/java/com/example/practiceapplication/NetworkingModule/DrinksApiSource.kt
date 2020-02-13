package com.example.practiceapplication.NetworkingModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkResult
import com.example.practiceapplication.PracticeApp
import com.example.practiceapplication.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


object DrinksApiSource {

    private val drinksApi: DrinksApiInterface by lazy {
        val context = PracticeApp.appContext

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val drinksInterceptor = DrinksApiInterceptor(context)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor (drinksInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.drinks_api_url))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(DrinksApiInterface::class.java)
    }


    // Get Random drink

    suspend fun getRandromDrinkCoroutines(): WDrinkResult = drinksApi.getRandromDrinkCoroutines()

    fun getRandromDrinkLiveData(): LiveData<WDrinkResult?> {

        val liveData = MutableLiveData<WDrinkResult?>()

        drinksApi.getRandromDrinkLiveData().enqueue(object : Callback<WDrinkResult> {
            override fun onFailure(call: Call<WDrinkResult>, t: Throwable) {
                Timber.e("Failure on livedata random drink call.")
                Timber.e(t)
            }

            override fun onResponse(call: Call<WDrinkResult>, response: Response<WDrinkResult>) {
                liveData.value = response.body()
            }

        })

        return liveData
    }



    // Get drink by id

    suspend fun getDrinkByIdCoroutine(drinkId: Int): WDrinkResult = drinksApi.getDrinkByIdCoroutine(drinkId)

}