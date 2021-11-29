package com.example.kitkat_movie.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kitkat_movie.R

class screen_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen4)

        val cButton: Button = findViewById<View>(R.id.Getstart) as Button
        cButton.setOnClickListener {
            val i = Intent(this, NavBar::class.java)
            startActivity(i)
        }
    }
}