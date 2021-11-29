package com.example.kitkat_movie.adapter

import AllMovies
import BanglaMovie
import HindiMovie
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R
import com.example.kitkat_movie.model.Movie
import com.example.kitkat_movie.others.PlayerView
import com.example.kitkat_movie.others.Preview

class RecyclerAdapterBanglaMovie(val context: Context) : RecyclerView.Adapter<RecyclerAdapterBanglaMovie.MyViewHolderBanglaMovie>() {

    var BanglaMoviesList : List<BanglaMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderBanglaMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolderBanglaMovie(view)
    }

    override fun getItemCount(): Int {
        return BanglaMoviesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderBanglaMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(BanglaMoviesList[position].movie_img).into(holder.Rimg)
        holder.title1.text = BanglaMoviesList[position].movie_name
        holder.release_year1.text = BanglaMoviesList[position].release_year.toString()

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, Preview::class.java)
            intent.putExtra("playUrl", BanglaMoviesList[position].playUrl)
            intent.putExtra("movie_name", BanglaMoviesList[position].movie_name)
            intent.putExtra("release_year", BanglaMoviesList[position].release_year)
            intent.putExtra("movie_img", BanglaMoviesList[position].movie_img)
            intent.putExtra("movie_img_lands", BanglaMoviesList[position].movie_img_lands)
            intent.putExtra("review_star", BanglaMoviesList[position].review_star)
            intent.putExtra("release_date", BanglaMoviesList[position].release_date)
            intent.putExtra("duration", BanglaMoviesList[position].duration)
            intent.putExtra("age", BanglaMoviesList[position].age)
            intent.putExtra("story", BanglaMoviesList[position].story)
            intent.putExtra("director", BanglaMoviesList[position].director)
            intent.putExtra("writer", BanglaMoviesList[position].writer)
            intent.putExtra("star", BanglaMoviesList[position].star)
            intent.putExtra("category_1", BanglaMoviesList[position].category_1)
            intent.putExtra("category_2", BanglaMoviesList[position].category_2)
            intent.putExtra("category_3", BanglaMoviesList[position].category_3)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setBanglaMoviesListItems(BanglaMoviesList: List<BanglaMovie>){
        this.BanglaMoviesList = BanglaMoviesList;
        notifyDataSetChanged()
    }

    class MyViewHolderBanglaMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val release_year1: TextView = itemView!!.findViewById(R.id.release_year1)

        val mainLayout: CardView = itemView!!.findViewById(R.id.cr1)

    }
}