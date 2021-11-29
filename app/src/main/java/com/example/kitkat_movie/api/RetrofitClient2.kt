package com.example.kitkat_movie.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient2 {
    const val BASE_URL = "https://covid19.aoladanna.info/"
    private var retrofit: Retrofit? = null
    val client2: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}
