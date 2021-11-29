package com.example.kitkat_movie.adapter

import AllMovies
import AllMovies1
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

class RecyclerAdapterAllMovie1(val context: Context) : RecyclerView.Adapter<RecyclerAdapterAllMovie1.MyViewHolderMovie1>() {

    var AllMoviesList1 : List<AllMovies1> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie1 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolderMovie1(view)
    }

    override fun getItemCount(): Int {
        return AllMoviesList1.size
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie1, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(AllMoviesList1[position].movie_img).into(holder.Rimg)
        holder.title1.text = AllMoviesList1[position].movie_name
        holder.release_year1.text = AllMoviesList1[position].release_year.toString()

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, Preview::class.java)
            intent.putExtra("playUrl", AllMoviesList1[position].playUrl)
            intent.putExtra("movie_name", AllMoviesList1[position].movie_name)
            intent.putExtra("release_year", AllMoviesList1[position].release_year)
            intent.putExtra("movie_img", AllMoviesList1[position].movie_img)
            intent.putExtra("movie_img_lands", AllMoviesList1[position].movie_img_lands)
            intent.putExtra("review_star", AllMoviesList1[position].review_star)
            intent.putExtra("release_date", AllMoviesList1[position].release_date)
            intent.putExtra("duration", AllMoviesList1[position].duration)
            intent.putExtra("age", AllMoviesList1[position].age)
            intent.putExtra("story", AllMoviesList1[position].story)
            intent.putExtra("director", AllMoviesList1[position].director)
            intent.putExtra("writer", AllMoviesList1[position].writer)
            intent.putExtra("star", AllMoviesList1[position].star)
            intent.putExtra("category_1", AllMoviesList1[position].category_1)
            intent.putExtra("category_2", AllMoviesList1[position].category_2)
            intent.putExtra("category_3", AllMoviesList1[position].category_3)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setAllMoviesList1Items(AllMoviesList1: List<AllMovies1>){
        this.AllMoviesList1 = AllMoviesList1;
        notifyDataSetChanged()
    }

    class MyViewHolderMovie1(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val release_year1: TextView = itemView!!.findViewById(R.id.release_year1)
        val mainLayout: CardView = itemView!!.findViewById(R.id.cr1)


    }
}