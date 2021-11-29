package com.example.kitkat_movie.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    const val BASE_URL = "https://covid19.aoladanna.info/"
    private var retrofit: Retrofit? = null
    private val okHttpClient= OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build()
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}