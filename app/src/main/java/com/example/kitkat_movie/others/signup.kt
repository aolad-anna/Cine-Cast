package com.example.kitkat_movie.others

import android.Manifest
import android.R.attr
import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_PICK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore

import android.util.Patterns
import android.widget.*
import com.example.kitkat_movie.model.Login
import com.example.covidbangladesh.models.Signup
import com.example.kitkat_movie.R
import com.example.kitkat_movie.api.ApiClient
import com.example.kitkat_movie.api.ApiInterface2
import com.example.kitkat_movie.onboarding.NavBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.app.ActivityCompat.startActivityForResult
import android.R.id.text1

import android.R.attr.data
import android.R.id
import android.net.Uri


class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQUEST_IMAGE_CAPTURE   = 1
        val PICK_IMAGE   = 1
        val MY_CAMERA_PERMISSION_CODE   = 100
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val kolon: ImageView =
            findViewById<View>(R.id.result) as ImageView
        val camera: Button =
            findViewById<View>(R.id.camera) as Button
//        val gallery: Button =
//            findViewById<View>(R.id.gallery) as Button

//        gallery.setOnClickListener {
//            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), MY_CAMERA_PERMISSION_CODE)
//            } else {
//                val intent = Intent()
//                intent.type = "image/*"
//                intent.action = Intent.ACTION_GET_CONTENT
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
//            }
//        }

        camera.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), MY_CAMERA_PERMISSION_CODE)
            } else {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

        val editTextTextPersonName: EditText =
            findViewById<View>(R.id.editTextTextPersonName) as EditText
        val editTextTextEmailAddress: EditText =
            findViewById<View>(R.id.editTextTextEmailAddress) as EditText
        val editTextPhone: EditText =
            findViewById<View>(R.id.editTextPhone) as EditText
        val editTextTextPassword: EditText =
            findViewById<View>(R.id.editTextTextPassword) as EditText
        val btnSignUp: Button = findViewById<View>(R.id.btnSignUp) as Button

        val pgressbar = findViewById<ProgressBar>(R.id.progress22)
        pgressbar.visibility=View.GONE

        fun CharSequence?.isValidEmail() = !isNullOrEmpty() && !Patterns.EMAIL_ADDRESS.matcher(this).matches()

        btnSignUp.setOnClickListener {
            val name = editTextTextPersonName.text.toString().trim()
            val email = editTextTextEmailAddress.text.toString().trim()
            val phone = editTextPhone.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()


            if (name.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Data is missing", Toast.LENGTH_LONG
                ).show()
                editTextTextPersonName.error = "Name required"
                editTextTextPersonName.requestFocus()
                return@setOnClickListener
            } else if (email.isEmpty()) {
                editTextTextEmailAddress.error = "Email required"
                editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            else if (email.isValidEmail()) {
                editTextTextEmailAddress.error = "Invalid email address"
                editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            else if (phone.isEmpty()) {
                editTextPhone.error = "Mobile No required"
                editTextPhone.requestFocus()
                return@setOnClickListener
            }
            else if (editTextPhone.getText().toString().length <11 || phone.length >11) {
                editTextPhone.error = "Mobile No Should be 11 Digits"
                editTextPhone.requestFocus()
                return@setOnClickListener
            }
            else if (password.isEmpty()) {
                editTextTextPassword.error = "Password required"
                editTextTextPassword.requestFocus()
                return@setOnClickListener
            }
            else if (editTextTextPassword.text.toString().length <5) {
                editTextTextPassword.error = "Weak Password"
                editTextTextPassword.requestFocus()
                return@setOnClickListener
            }
            else if (email.isEmpty() && name.isEmpty() && phone.isEmpty() && password.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Data is missing!!!", Toast.LENGTH_LONG
                ).show()
            }
            else if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty())
            {
                val pgressbar = findViewById<ProgressBar>(R.id.progress22)
                pgressbar.visibility=View.VISIBLE
                btnSignUp.visibility=View.GONE
            }

            val apiService99 = ApiClient.client!!.create(ApiInterface2::class.java)
            val call99: Call<Signup> = apiService99.getSignup(name,email,phone,password)
            call99.enqueue(object : Callback<Signup> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                    if(response !=null)
                    {
                        val pgressbar = findViewById<ProgressBar>(R.id.progress22)
                        pgressbar.visibility=View.GONE
                        btnSignUp.visibility=View.VISIBLE
                        Toast.makeText(applicationContext, "Successfully Signup", Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext, Login::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                        startActivity(intent)
                    }
                    else
                    {
                        val pgressbar = findViewById<ProgressBar>(R.id.progress22)
                        pgressbar.visibility=View.GONE
                        btnSignUp.visibility=View.VISIBLE
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
                    }

                }

                override fun onFailure(call: Call<Signup>, t: Throwable) {
                    val pp =""

                }

            })
        }
        val sign_in = findViewById<View>(R.id.button3) as Button
        sign_in.setOnClickListener { view ->
            val intent = Intent(view.context, signin::class.java)
            view.context.startActivity(intent)
        }

        val conti = findViewById<View>(R.id.conti) as Button
        conti.setOnClickListener { view ->
            val intent = Intent(view.context, NavBar::class.java)
            view.context.startActivity(intent)
        }
    }

    @SuppressLint("RestrictedApi")
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val REQUEST_IMAGE_CAPTURE = 1
        val REQUEST_PICK_IMAGE =11
        val kolon: ImageView =
            findViewById<View>(R.id.result) as ImageView
        if (requestCode == REQUEST_IMAGE_CAPTURE  && resultCode == RESULT_OK) when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                kolon.setImageBitmap(imageBitmap)
            }
        }
    }
}