package com.example.kitkat_movie.adapter

import Tv1
import Tv2
import Tv3
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

class RecyclerAdapterTv3(val context: Context) : RecyclerView.Adapter<RecyclerAdapterTv3.MyViewHolderTv3>() {

    var TVList3 : List<Tv3> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTv3 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_round,parent,false)
        return MyViewHolderTv3(view)
    }

    override fun getItemCount(): Int {
        return TVList3.size
    }

    override fun onBindViewHolder(holder: MyViewHolderTv3, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(TVList3[position].movie_img).into(holder.Rimg)

        holder.mainLayout.setOnClickListener{
            val intent = Intent(context, PlayerViewTv::class.java)
            intent.putExtra("playUrl", TVList3[position].playUrl)
            intent.putExtra("movie_name", TVList3[position].movie_name)
            intent.putExtra("release_year", TVList3[position].release_year.toString())
            intent.putExtra("movie_img", TVList3[position].movie_img)
            intent.putExtra("review_star", TVList3[position].review_star.toString())
            intent.putExtra("release_date", TVList3[position].release_date)
            context.startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTv3Items(TVList3: List<Tv3>){
        this.TVList3 = TVList3;
        notifyDataSetChanged()
    }

    class MyViewHolderTv3(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.imageView9)

        val mainLayout: CardView = itemView!!.findViewById(R.id.tv_y)

    }
}