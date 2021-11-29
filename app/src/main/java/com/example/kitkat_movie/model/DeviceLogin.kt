package com.example.kitkat_movie.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeviceLogin(

   @SerializedName("client_ip")
   @Expose
   val client_ip: String?,

   @SerializedName("country_code")
   @Expose
   val country_code: String?,

   @SerializedName("device_id")
   @Expose
   val device_id: String?,

   @SerializedName("language_code")
   @Expose
   val language_code: String?,


   @SerializedName("token") val token : String,
   @SerializedName("duration_ms") val duration_ms : Int
)