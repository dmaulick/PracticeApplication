package com.example.practiceapplication.NetworkingModule

import android.content.Context
import com.example.practiceapplication.R
import okhttp3.Interceptor
import okhttp3.Response

class DrinksApiInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(context.getString(R.string.drinks_api_host_header), context.getString(R.string.drinks_api_host_header_content))
            .addHeader(context.getString(R.string.drinks_api_key_header), context.getString(R.string.drinks_api_key_header_content))
            .build()

        return chain.proceed(request)
    }
}