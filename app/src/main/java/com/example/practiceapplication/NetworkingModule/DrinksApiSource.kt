package com.example.practiceapplication.NetworkingModule

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class DrinksApiSource {


    private fun createDrinksApiSource() {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://backend.example.com")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create<ApiClient>(ApiClient::class.java!!)
    }

}