package com.example.kitkat_movie.adapter

import Genresss
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

class RecyclerAdaptersss(val context: Context) : RecyclerView.Adapter<RecyclerAdaptersss.MyViewHolder3>() {

    var GenList : List<Genresss> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder3 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy3,parent,false)
        return MyViewHolder3(view)
    }

    override fun getItemCount(): Int {
        return GenList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder3, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint3)
            .error(R.drawable.blueprint3)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(GenList[position].thumbnails.background).into(holder.Rimg)
        holder.title1.text = GenList[position].label

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setGenListItems(GenList: List<Any>){
        this.GenList = GenList as List<Genresss>
        notifyDataSetChanged()
    }

    class MyViewHolder3(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)


    }
}