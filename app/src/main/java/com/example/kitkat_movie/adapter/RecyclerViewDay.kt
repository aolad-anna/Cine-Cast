package com.example.kitkat_movie.adapter

import AllMovies
import Day
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
import com.example.kitkat_movie.others.DayPlayer
import com.example.kitkat_movie.others.PlayerView
import com.example.kitkat_movie.others.PlayerViewTv
import com.example.kitkat_movie.others.Preview

class RecyclerAdapterDay(val context: Context) : RecyclerView.Adapter<RecyclerAdapterDay.MyViewHolderMovie>() {

    var DayList : List<Day> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.shorts_card,parent,false)
        return MyViewHolderMovie(view)
    }

    override fun getItemCount(): Int {
        return DayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(DayList[position].movie_img).into(holder.Rimg)

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, DayPlayer::class.java)
            intent.putExtra("playUrl", DayList[position].playUrl)
            intent.putExtra("movie_name", DayList[position].movie_name)
            intent.putExtra("release_year", DayList[position].release_year)
            intent.putExtra("movie_img", DayList[position].movie_img)
            intent.putExtra("movie_img_lands", DayList[position].movie_img_lands)
            intent.putExtra("review_star", DayList[position].review_star)
            intent.putExtra("release_date", DayList[position].release_date)
            intent.putExtra("duration", DayList[position].duration)
            intent.putExtra("age", DayList[position].age)
            intent.putExtra("story", DayList[position].story)
            intent.putExtra("director", DayList[position].director)
            intent.putExtra("writer", DayList[position].writer)
            intent.putExtra("star", DayList[position].star)
            intent.putExtra("category_1", DayList[position].category_1)
            intent.putExtra("category_2", DayList[position].category_2)
            intent.putExtra("category_3", DayList[position].category_3)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setAllDayListItems(DayList: List<Day>){
        this.DayList = DayList;
        notifyDataSetChanged()
    }

    class MyViewHolderMovie(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val mainLayout: CardView= itemView!!.findViewById(R.id.cr1)

    }
}