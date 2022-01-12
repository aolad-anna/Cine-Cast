package com.example.kitkat_movie.model

import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("status") var status : Int,
    @SerializedName("data") val data : List<Data>,
    @SerializedName("msg") val msg : String
)