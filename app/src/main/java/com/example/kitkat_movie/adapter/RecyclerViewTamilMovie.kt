package com.example.kitkat_movie.adapter

import AllMovies
import BanglaMovie
import HindiMovie
import TamilMovie
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

class RecyclerAdapterTamilMovie(val context: Context) : RecyclerView.Adapter<RecyclerAdapterTamilMovie.MyViewHolderTamilMovie>() {

    var TamilMoviesList : List<TamilMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTamilMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolderTamilMovie(view)
    }

    override fun getItemCount(): Int {
        return TamilMoviesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderTamilMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(TamilMoviesList[position].movie_img).into(holder.Rimg)
        holder.title1.text = TamilMoviesList[position].movie_name
        holder.release_year1.text = TamilMoviesList[position].release_year.toString()

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, Preview::class.java)
            intent.putExtra("playUrl", TamilMoviesList[position].playUrl)
            intent.putExtra("movie_name", TamilMoviesList[position].movie_name)
            intent.putExtra("release_year", TamilMoviesList[position].release_year)
            intent.putExtra("movie_img", TamilMoviesList[position].movie_img)
            intent.putExtra("movie_img_lands", TamilMoviesList[position].movie_img_lands)
            intent.putExtra("review_star", TamilMoviesList[position].review_star)
            intent.putExtra("release_date", TamilMoviesList[position].release_date)
            intent.putExtra("duration", TamilMoviesList[position].duration)
            intent.putExtra("age", TamilMoviesList[position].age)
            intent.putExtra("story", TamilMoviesList[position].story)
            intent.putExtra("director", TamilMoviesList[position].director)
            intent.putExtra("writer", TamilMoviesList[position].writer)
            intent.putExtra("star", TamilMoviesList[position].star)
            intent.putExtra("category_1", TamilMoviesList[position].category_1)
            intent.putExtra("category_2", TamilMoviesList[position].category_2)
            intent.putExtra("category_3", TamilMoviesList[position].category_3)
            context.startActivity(intent)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTamilMoviesListItems(TamilMoviesList: List<TamilMovie>){
        this.TamilMoviesList = TamilMoviesList;
        notifyDataSetChanged()
    }

    class MyViewHolderTamilMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val release_year1: TextView = itemView!!.findViewById(R.id.release_year1)
        val mainLayout: CardView = itemView!!.findViewById(R.id.cr1)
    }
}