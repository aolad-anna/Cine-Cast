package com.example.kitkat_movie.adapter

import Eraa
import Eras_s
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

class RecyclerAdapterssss(val context: Context) : RecyclerView.Adapter<RecyclerAdapterssss.MyViewHolder4>() {

    var ErList : List<Eraa> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder4 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy1,parent,false)
        return MyViewHolder4(view)
    }

    override fun getItemCount(): Int {
        return ErList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder4, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint3)
            .error(R.drawable.blueprint3)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(ErList[position].movie_img).into(holder.Rimg)
        holder.title1.text = ErList[position].movie_name
        holder.singer.text = ErList[position].release_year
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setErListItems(ErList: List<Eraa>){
        this.ErList = ErList
        notifyDataSetChanged()
    }

    class MyViewHolder4(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val singer: TextView = itemView!!.findViewById(R.id.singer)
    }
}