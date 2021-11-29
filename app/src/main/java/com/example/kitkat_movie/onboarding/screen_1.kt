package com.example.kitkat_movie.onboarding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kitkat_movie.R

class screen_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        val cButton: Button = findViewById<View>(R.id.button) as Button
        cButton.setOnClickListener {
            val i = Intent(this, screen_2::class.java)
            startActivity(i)
        }
    }
}