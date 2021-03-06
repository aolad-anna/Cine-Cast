package com.example.kitkat_movie.adapter

import Lang
import Languagess
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

class RecyclerAdapterss(val context: Context) : RecyclerView.Adapter<RecyclerAdapterss.MyViewHolder2>() {

    var LangList : List<Lang> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recy1,parent,false)
        return MyViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return LangList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint3)
            .error(R.drawable.blueprint3)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(LangList[position].movie_img).into(holder.Rimg)
        holder.title1.text = LangList[position].movie_name
        holder.singer.text = LangList[position].release_year
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setLangListItems(LangList: List<Lang>){
        this.LangList = LangList
        notifyDataSetChanged()
    }

    class MyViewHolder2(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val title1: TextView = itemView!!.findViewById(R.id.title1)
        val singer: TextView = itemView!!.findViewById(R.id.singer)

    }
}