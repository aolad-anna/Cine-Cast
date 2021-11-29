package com.example.kitkat_movie.adapter

import AllMovies
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

class RecyclerAdapterHindiMovie(val context: Context) : RecyclerView.Adapter<RecyclerAdapterHindiMovie.MyViewHolderHindiMovie>() {

    var HindiMoviesList : List<HindiMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHindiMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolderHindiMovie(view)
    }

    override fun getItemCount(): Int {
        return HindiMoviesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderHindiMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(HindiMoviesList[position].movie_img).into(holder.Rimg)
        holder.title1.text = HindiMoviesList[position].movie_name
        holder.release_year1.text = HindiMoviesList[position].release_year.toString()

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, Preview::class.java)
            intent.putExtra("playUrl", HindiMoviesList[position].playUrl)
            intent.putExtra("movie_name", HindiMoviesList[position].movie_name)
            intent.putExtra("release_year", HindiMoviesList[position].release_year)
            intent.putExtra("movie_img", HindiMoviesList[position].movie_img)
            intent.putExtra("movie_img_lands", HindiMoviesList[position].movie_img_lands)
            intent.putExtra("review_star", HindiMoviesList[position].review_star)
            intent.putExtra("release_date", HindiMoviesList[position].release_date)
            intent.putExtra("duration", HindiMoviesList[position].duration)
            intent.putExtra("age", HindiMoviesList[position].age)
            intent.putExtra("story", HindiMoviesList[position].story)
            intent.putExtra("director", HindiMoviesList[position].director)
            intent.putExtra("writer", HindiMoviesList[position].writer)
            intent.putExtra("star", HindiMoviesList[position].star)
            intent.putExtra("category_1", HindiMoviesList[position].category_1)
            intent.putExtra("category_2", HindiMoviesList[position].category_2)
            intent.putExtra("category_3", HindiMoviesList[position].category_3)
            context.startActivity(intent)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setHindiMoviesListItems(HindiMoviesList: List<HindiMovie>){
        this.HindiMoviesList = HindiMoviesList;
        notifyDataSetChanged()
    }

    class MyViewHolderHindiMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val release_year1: TextView = itemView!!.findViewById(R.id.release_year1)
        val mainLayout: CardView = itemView!!.findViewById(R.id.cr1)

    }
}