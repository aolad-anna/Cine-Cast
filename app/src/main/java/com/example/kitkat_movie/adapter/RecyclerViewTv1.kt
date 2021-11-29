package com.example.kitkat_movie.adapter

import Tv1
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R
import com.example.kitkat_movie.others.PlayerView
import com.example.kitkat_movie.others.PlayerViewTv

class RecyclerAdapterTv1(val context: Context) : RecyclerView.Adapter<RecyclerAdapterTv1.MyViewHolderTv1>() {

    var TVList1 : List<Tv1> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTv1 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_round1,parent,false)
        return MyViewHolderTv1(view)
    }

    override fun getItemCount(): Int {
        return TVList1.size
    }

    override fun onBindViewHolder(holder: MyViewHolderTv1, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(TVList1[position].movie_img).into(holder.Rimg)

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, PlayerViewTv::class.java)
            intent.putExtra("playUrl", TVList1[position].playUrl)
            intent.putExtra("movie_name", TVList1[position].movie_name)
            intent.putExtra("release_year", TVList1[position].release_year.toString())
            intent.putExtra("movie_img", TVList1[position].movie_img)
            intent.putExtra("review_star", TVList1[position].review_star.toString())
            intent.putExtra("release_date", TVList1[position].release_date)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTv1Items(TVList1: List<Any>){
        this.TVList1 = TVList1 as List<Tv1>;
        notifyDataSetChanged()
    }

    class MyViewHolderTv1(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)
        val mainLayout: CardView = itemView!!.findViewById(R.id.tv_h)

    }
}