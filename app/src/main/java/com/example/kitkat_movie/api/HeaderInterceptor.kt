package com.example.kitkat_movie.api

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.kitkat_movie.R
import com.example.kitkat_movie.model.DeviceLogin
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("X-API-KEY", "0sT3Mp1M7B1xiShSbyjal3tO5fFi5rUZ")
                .addHeader("deviceplatform", "android")
                .addHeader("Authorization", "Bearer eyJnYWxheGllVG9rZW4iOiIxYnBQNlM4WnZvdTViVTk3ejIxdXA1LzNIMnp4Ynp0aVk2UlpseFlGem43WW1iMmp0QlJ5UFlTdDQzZ2FpTUhnaWVTVkxSSTg3V3VTMnlNcmlqQ1pwT1ZzYkVkQXpqajlGQ0FjVERJZ2s3OU44dkFYUmdhTTJCblFGVnB6KytOSzdEdDlxM3lQWmE0UTkxUGZtQmdqSXFBPT0iLCJkZXRhaWxzIjp7Imxhbmd1YWdlIjoiZW5nIiwiY291bnRyeSI6IkJEIn19")
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0")
                .build()
        )
    }
}