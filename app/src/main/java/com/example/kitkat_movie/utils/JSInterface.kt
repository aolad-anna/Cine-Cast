package com.example.kitkat_movie.utils

import android.content.Context
import android.content.Intent
import android.webkit.JavascriptInterface
import com.example.kitkat_movie.onboarding.NavBar

class JSInterface(var context: Context) {

    @JavascriptInterface
    fun switchActivity() {
        val intent = Intent(context, NavBar::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }
}