package com.example.kitkat_movie.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kitkat_movie.R
import com.example.kitkat_movie.api.InternetConnection
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = getSharedPreferences("prefs", 0)
        val firstRun = settings.getBoolean("firstRun", false)

        if (!firstRun) //if running for first time
        //Splash will load for first time
        {
            val editor = settings.edit()
            editor.putBoolean("firstRun", true)
            editor.apply()

            val imageView =
                findViewById<View>(R.id.splash) as LinearLayout // Declare an imageView to show the animation.

            val anim = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.bottom_to_top
            ) // Create the animation.


            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    if (InternetConnection.checkConnection(this@MainActivity)) {
                        val i = Intent(baseContext, Slider::class.java)
                        startActivity(i)
                    } else {
                        val rootView =findViewById<View>(R.id.coordinatorLayout)
                        val snackbar = Snackbar

                            .make(rootView,
                                "No internet connection!",
                                Snackbar.LENGTH_LONG
                            )
                            .setDuration(80000)
                            .setActionTextColor(Color.MAGENTA)
                            .setAction("RETRY") {
                                val i = Intent(baseContext, MainActivity::class.java)
                                startActivity(i)
                            }


                        val sbView = snackbar.view
                        val textView = sbView.findViewById<View>(R.id.snackbar_text) as TextView
                        sbView.setBackgroundColor(Color.WHITE)
                        textView.setTextColor(Color.BLACK)

                        snackbar.show()

                    }
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
            imageView.startAnimation(anim)
        }
        else
        {
            val imageView =
                findViewById<View>(R.id.splash) as LinearLayout // Declare an imageView to show the animation.

            val anim = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.bottom_to_top
            ) // Create the animation.

            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                @SuppressLint("ResourceType")
                override fun onAnimationEnd(animation: Animation?)
                {
                    if (InternetConnection.checkConnection(this@MainActivity)) {
                        val i = Intent(baseContext, Slider::class.java)
                        startActivity(i)
                    } else {
                        val rootView =findViewById<View>(R.id.coordinatorLayout)
                        val snackbar = Snackbar

                            .make(rootView,
                                "No internet connection!",
                                Snackbar.LENGTH_LONG
                            )
                            .setDuration(80000)
                            .setActionTextColor(Color.MAGENTA)
                            .setAction("RETRY") {
                                val i = Intent(baseContext, MainActivity::class.java)
                                startActivity(i)
                            }


                        val sbView = snackbar.view
                        val textView = sbView.findViewById<View>(R.id.snackbar_text) as TextView
                        sbView.setBackgroundColor(Color.WHITE)
                        textView.setTextColor(Color.BLACK)

                        snackbar.show()

                    }

                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })

            imageView.startAnimation(anim)
        }

    }
}