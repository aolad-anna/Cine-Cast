package com.example.kitkat_movie.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kitkat_movie.utils.Animatoo
import com.example.kitkat_movie.R
import com.example.kitkat_movie.adapter.OnboardingViewPagerAdapter
import com.example.kitkat_movie.others.signin
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Slider : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager2
    private lateinit var textSkip: TextView


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        mViewPager = findViewById(R.id.viewPager)
        val indi = findViewById<TabLayout>(R.id.pageIndicator)
        mViewPager.adapter = OnboardingViewPagerAdapter(this, this)
        TabLayoutMediator(indi, mViewPager) { _, _ -> }.attach()

        val btnNextStep: Button = findViewById<View>(R.id.btn_next_step) as Button

        btnNextStep.setOnClickListener {
            if (getItem() > mViewPager.childCount) {
                finish()
                val intent =
                    Intent(applicationContext, signin::class.java)
                startActivity(intent)
                Animatoo.animateSlideLeft(this)
            } else {
                mViewPager.setCurrentItem(getItem() + 1, true)
            }
        }

    }

    private fun getItem(): Int {
        return mViewPager.currentItem
    }

}