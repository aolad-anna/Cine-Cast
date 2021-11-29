package com.example.kitkat_movie.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R
import com.example.kitkat_movie.model.Movie

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var NotifyList : List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return NotifyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint3)
            .error(R.drawable.blueprint3)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(NotifyList[position].thumbnails.album).into(holder.Rimg)
        holder.title1.text = NotifyList[position].title
        holder.artist_display_name1.text = NotifyList[position].artist_display_name

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setNotifyListItems(NotifyList: List<Movie>){
        this.NotifyList = NotifyList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        //        val release_year1: TextView = itemView!!.findViewById(R.id.release_year1)
//        val genre1: TextView = itemView!!.findViewById(R.id.genre1)
//        val era1: TextView = itemView!!.findViewById(R.id.era1)
        val artist_display_name1: TextView = itemView!!.findViewById(R.id.artist_display_name1)
//        val lead_gender1: TextView = itemView!!.findViewById(R.id.lead_gender1)

    }
}