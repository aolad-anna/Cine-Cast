package com.example.kitkat_movie.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.kitkat_movie.R

class screen_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        val cButton: Button = findViewById<View>(R.id.button2) as Button
        cButton.setOnClickListener {
            val i = Intent(this, screen_4::class.java)
            startActivity(i)
        }
    }
}