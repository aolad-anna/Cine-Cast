package com.example.kitkat_movie.api


import AllMovies
import AllMovies1
import BanglaMovie
import Carousel
import Category
import HindiMovie
import TamilMovie
import Tv
import Tv1
import Tv2
import Tv3
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface2 {

    @GET("movies.php")
    fun getAllMovies() : Call<List<AllMovies>>

    @GET("movies1.php")
    fun getAllMovies1() : Call<List<AllMovies1>>

    @GET("carousel.php")
    fun getCarousel() : Call<List<Carousel>>

    @GET("tv.php")
    fun getTv() : Call<List<Tv>>

    @GET("tv1.php")
    fun getTv1() : Call<List<Tv1>>

    @GET("tv2.php")
    fun getTv2() : Call<List<Tv2>>

    @GET("tv3.php")
    fun getTv3() : Call<List<Tv3>>

    @GET("hindi_movie.php")
    fun getHindiMovie() : Call<List<HindiMovie>>

    @GET("bangla_movie.php")
    fun getBanglaMovie() : Call<List<BanglaMovie>>

    @GET("tamil_movie.php")
    fun getTamilMovie() : Call<List<TamilMovie>>

    @GET("category.php")
    fun getCategory() : Call<List<Category>>

}