package com.example.kitkat_movie.others

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.kitkat_movie.R
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.onboarding.MainActivity
import com.example.kitkat_movie.onboarding.NavBar
import kotlin.system.exitProcess

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initViews()

        val pButton = findViewById<View>(R.id.imageView722) as ImageView
        pButton.setOnClickListener { view ->
            super.onBackPressed();
        }


        val mPref = SharedPrefManager.getInstance(applicationContext)
        val profile_name: TextView = findViewById(R.id.names)
        profile_name.text = mPref.data.name.toString()

        if (SharedPrefManager.getInstance(applicationContext).isLoggedIn) {
            val mPref = SharedPrefManager.getInstance(applicationContext)
            val profile_name: TextView = findViewById(R.id.names)
            profile_name.text = mPref.data.name.toString()
            val profile_email: TextView = findViewById(R.id.emails)
            profile_email.text = mPref.data.email.toString()
            val profile_phone: TextView = findViewById(R.id.phones)
            profile_phone.text = mPref.data.phone.toString()

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
        } else {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initViews() {
        val btn_pay_with_bkash10 = findViewById<View>(R.id.pay_with_bkash10) as Button
        btn_pay_with_bkash10.setOnClickListener {
            val intent = Intent(this, BkashPaymentActivity::class.java)
            intent.putExtra("amount", "10")
            //intent.putExtra("intent", "sale") //if you require Immediate transfer
            intent.putExtra("intent", "authorization") // if you require Auth & Capture
            startActivity(intent)
        }

        val btn_pay_with_bkash15 = findViewById<View>(R.id.pay_with_bkash15) as Button
        btn_pay_with_bkash15.setOnClickListener {
            val intent = Intent(this, BkashPaymentActivity::class.java)
            intent.putExtra("amount", "15")
            //intent.putExtra("intent", "sale") //if you require Immediate transfer
            intent.putExtra("intent", "authorization") // if you require Auth & Capture
            startActivity(intent)
        }

        val btn_pay_with_bkash20 = findViewById<View>(R.id.pay_with_bkash20) as Button
        btn_pay_with_bkash20.setOnClickListener {
            val intent = Intent(this, BkashPaymentActivity::class.java)
            intent.putExtra("amount", "20")
            //intent.putExtra("intent", "sale") //if you require Immediate transfer
            intent.putExtra("intent", "authorization") // if you require Auth & Capture
            startActivity(intent)
        }

    }

}



















