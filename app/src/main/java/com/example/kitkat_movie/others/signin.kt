package com.example.kitkat_movie.others

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import com.example.kitkat_movie.model.Login
import com.example.kitkat_movie.R
import com.example.kitkat_movie.api.ApiClient
import com.example.kitkat_movie.api.ApiInterface2
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.onboarding.NavBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess


class signin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        var sharedpref: SharedPreferences?
        val editTextTextEmailAddress: EditText =
            findViewById<View>(R.id.editTextTextEmailAddress) as EditText
        val editTextTextPassword: EditText =
            findViewById<View>(R.id.editTextTextPassword) as EditText
        val btnLogin: Button = findViewById<View>(R.id.btnLogin) as Button
        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
            return false
        }
        val pgressbr = findViewById<ProgressBar>(R.id.progress123)
        pgressbr.visibility=View.GONE

        fun CharSequence?.isValidEmail() = !isNullOrEmpty() && !Patterns.EMAIL_ADDRESS.matcher(this).matches()
        btnLogin.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()

             if (email.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Data is missing", Toast.LENGTH_LONG
                ).show()
                editTextTextEmailAddress.error = "Email required"
                editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
             else if (email.isValidEmail()) {
                 editTextTextEmailAddress.error = "Invalid email address"
                 editTextTextEmailAddress.requestFocus()
                 return@setOnClickListener
             }
            else if (password.isEmpty()) {
                editTextTextPassword.error = "Password required"
                editTextTextPassword.requestFocus()
                return@setOnClickListener
            }

            else if (email.isNotEmpty() && password.isNotEmpty())
            {
                val pgressbr = findViewById<ProgressBar>(R.id.progress123)
                pgressbr.visibility=View.VISIBLE
                btnLogin.visibility=View.GONE
            }
            val apiService88 = ApiClient.client!!.create(ApiInterface2::class.java)
            val call88: Call<Login> = apiService88.getLogin(email,password)
            call88.enqueue(object : Callback<Login> {
                @SuppressLint("SetTextI18n", "CommitPrefEdits")
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response != null) {
                        if (response.body()!!.status == 1) {
                            val pgressbr = findViewById<ProgressBar>(R.id.progress123)
                            pgressbr.visibility=View.GONE
                            btnLogin.visibility = View.VISIBLE
                            SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.data!!)
                            Toast.makeText(
                                applicationContext,
                                "Successfully Login",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(applicationContext, NavBar::class.java)
                            startActivity(intent)
                        } else {
                            val pgressbr = findViewById<ProgressBar>(R.id.progress123)
                            pgressbr.visibility=View.VISIBLE
                            btnLogin.visibility = View.VISIBLE
                            Toast.makeText(
                                applicationContext,
                                "Invalid User Id or Password!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("onFailure", t.toString());
                }

            })


        }
            val sign_up = findViewById<View>(R.id.context) as Button
            sign_up.setOnClickListener { view ->
                val intent = Intent(view.context, signup::class.java)
                view.context.startActivity(intent)
            }
            val conti = findViewById<View>(R.id.conti) as Button
            conti.setOnClickListener { view ->
                val intent = Intent(view.context, NavBar::class.java)
                view.context.startActivity(intent)
            }
        }

    override fun onStart() {
        super.onStart()

        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, NavBar::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(baseContext, NavBar::class.java)
        startActivity(intent)
    }
}
