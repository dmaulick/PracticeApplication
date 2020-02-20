package com.example.practiceapplication.NetworkingModule

import android.content.Context
import com.example.practiceapplication.R
import com.example.practiceapplication.Utils.ContextUtils.IStringContext
import okhttp3.Interceptor
import okhttp3.Response

class DrinksApiInterceptor(private val stringContext: IStringContext) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(stringContext.getString(R.string.drinks_api_host_header), stringContext.getString(R.string.drinks_api_host_header_content))
            .addHeader(stringContext.getString(R.string.drinks_api_key_header), stringContext.getString(R.string.drinks_api_key_header_content))
            .build()

        return chain.proceed(request)
    }
}