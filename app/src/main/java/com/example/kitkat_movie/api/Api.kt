package com.example.kitkat_movie.api

import Eraa
import Gen
import Lang
import Party
import com.example.kitkat_movie.model.DeviceLogin
import com.example.kitkat_movie.model.Movie
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {

    @GET("songs")
    fun getMovies() : Call<List<Movie>>

    @GET("party-mixes")
    fun getParty() : Call<List<Party>>

    @GET("languages")
    fun getLang() : Call<Lang>

    @GET("genres")
    fun getGenres() : Call<Gen>

    @GET("eras")
    fun getErass() : Call<Eraa>

////    @GET("notify_api.php")
////    fun getNotify(
//////        @Query("ndate") ndate: String?,
//////        @Query("details") details: String?
////    ): Call<Notify>
//
//
//    @GET("login.php")
//    fun getLogin(
//        @Query("email") email: String?,
//        @Query("password") password: String?
//    ): Call<Login>
//
//    @POST("reg_api.php")
//    fun getSignup(
//        @Query("name") name: String?,
//        @Query("email") email: String?,
//        @Query("phone") phone: String?,
//        @Query("password") password: String?
//    ): Call<Signup>

}