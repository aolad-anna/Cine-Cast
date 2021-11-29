package com.example.kitkat_movie.others

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.kitkat_movie.R

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val LButton = findViewById<View>(R.id.imageView722) as ImageView
        LButton.setOnClickListener { view ->
            super.onBackPressed();
        }
    }
}