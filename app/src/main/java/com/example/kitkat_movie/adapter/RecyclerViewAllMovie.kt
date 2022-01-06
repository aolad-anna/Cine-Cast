package com.example.kitkat_movie.adapter

import AllMovies
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R
import com.example.kitkat_movie.model.Movie
import com.example.kitkat_movie.others.PlayerView
import com.example.kitkat_movie.others.Preview

class RecyclerAdapterAllMovie(val context: Context) : RecyclerView.Adapter<RecyclerAdapterAllMovie.MyViewHolderMovie>() {

    var AllMoviesList : List<AllMovies> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MyViewHolderMovie(view)
    }

    override fun getItemCount(): Int {
        return AllMoviesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(AllMoviesList[position].movie_img).into(holder.Rimg)
        holder.title1.text = AllMoviesList[position].movie_name
        holder.star2.text = AllMoviesList[position].review_star

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, Preview::class.java)
            intent.putExtra("playUrl", AllMoviesList[position].playUrl)
            intent.putExtra("movie_name", AllMoviesList[position].movie_name)
            intent.putExtra("release_year", AllMoviesList[position].release_year)
            intent.putExtra("movie_img", AllMoviesList[position].movie_img)
            intent.putExtra("movie_img_lands", AllMoviesList[position].movie_img_lands)
            intent.putExtra("review_star", AllMoviesList[position].review_star)
            intent.putExtra("release_date", AllMoviesList[position].release_date)
            intent.putExtra("duration", AllMoviesList[position].duration)
            intent.putExtra("age", AllMoviesList[position].age)
            intent.putExtra("story", AllMoviesList[position].story)
            intent.putExtra("director", AllMoviesList[position].director)
            intent.putExtra("writer", AllMoviesList[position].writer)
            intent.putExtra("star", AllMoviesList[position].star)
            intent.putExtra("category_1", AllMoviesList[position].category_1)
            intent.putExtra("category_2", AllMoviesList[position].category_2)
            intent.putExtra("category_3", AllMoviesList[position].category_3)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setAllMoviesListListItems(AllMoviesList: List<AllMovies>){
        this.AllMoviesList = AllMoviesList;
        notifyDataSetChanged()
    }

    class MyViewHolderMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val star2: TextView = itemView!!.findViewById(R.id.star2)
        val mainLayout: CardView= itemView!!.findViewById(R.id.cr1)

    }
}