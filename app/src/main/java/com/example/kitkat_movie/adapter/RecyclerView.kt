package com.example.kitkat_movie.adapter

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
import com.example.kitkat_movie.others.AudioPlayerView
import com.example.kitkat_movie.others.Preview

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var NotifyList : List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy1,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return NotifyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint3)
            .error(R.drawable.blueprint3)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(NotifyList[position].movie_img).into(holder.Rimg)
        holder.title1.text = NotifyList[position].movie_name
        holder.singer.text = NotifyList[position].release_year

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, AudioPlayerView::class.java)
            intent.putExtra("playUrl", NotifyList[position].playUrl)
            intent.putExtra("movie_name", NotifyList[position].movie_name)
            intent.putExtra("release_year", NotifyList[position].release_year)
            intent.putExtra("movie_img", NotifyList[position].movie_img)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setNotifyListItems(NotifyList: List<Movie>){
        this.NotifyList = NotifyList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val singer: TextView = itemView!!.findViewById(R.id.singer)
        val mainLayout: CardView = itemView!!.findViewById(R.id.audio_touch)
//        val lead_gender1: TextView = itemView!!.findViewById(R.id.lead_gender1)audio_touch

    }
}