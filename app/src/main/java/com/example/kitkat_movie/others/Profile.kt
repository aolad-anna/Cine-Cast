package com.example.kitkat_movie.others

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.kitkat_movie.R
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.onboarding.NavBar
import kotlin.system.exitProcess

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val pButton = findViewById<View>(R.id.imageView722) as ImageView
        pButton.setOnClickListener { view ->
            super.onBackPressed();
        }

        val mPref = SharedPrefManager.getInstance(applicationContext)
        val profile_name: TextView = findViewById(R.id.names)
        profile_name.text = mPref.data.name.toString()

        if(SharedPrefManager.getInstance(applicationContext).isLoggedIn) {
            val mPref = SharedPrefManager.getInstance(applicationContext)
            val profile_name: TextView = findViewById(R.id.names)
            profile_name.text = mPref.data.name.toString()
            val profile_email: TextView = findViewById(R.id.emails)
            profile_email.text = mPref.data.email.toString()
            val profile_phone: TextView = findViewById(R.id.phones)
            profile_phone.text = mPref.data.phone.toString()
        }

        val outButton = findViewById<View>(R.id.signout1) as Button
        outButton.setOnClickListener { view ->
            val mPref = SharedPrefManager.getInstance(applicationContext)
            mPref.clear(profile_name)
            Toast.makeText(
                applicationContext,
                "Signout Successfull",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(view.context, NavBar::class.java)
            view.context.startActivity(intent)
        }

    }

}



















