package com.example.kitkat_movie.adapter

import AllMovies
import Tv
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
import com.example.kitkat_movie.others.PlayerViewTv

class RecyclerAdapterTv(val context: Context) : RecyclerView.Adapter<RecyclerAdapterTv.MyViewHolderMovie>() {

    var TVList : List<Tv> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_round,parent,false)
        return MyViewHolderMovie(view)
    }

    override fun getItemCount(): Int {
        return TVList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(TVList[position].movie_img).into(holder.Rimg)
        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, PlayerViewTv::class.java)
            intent.putExtra("playUrl", TVList[position].playUrl)
            intent.putExtra("movie_name", TVList[position].movie_name)
            intent.putExtra("release_year", TVList[position].release_year.toString())
            intent.putExtra("movie_img", TVList[position].movie_img)
            intent.putExtra("review_star", TVList[position].review_star.toString())
            intent.putExtra("release_date", TVList[position].release_date)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTvItems(TVList: List<Tv>){
        this.TVList = TVList;
        notifyDataSetChanged()
    }

    class MyViewHolderMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val mainLayout: CardView = itemView!!.findViewById(R.id.tv_y)

    }
}