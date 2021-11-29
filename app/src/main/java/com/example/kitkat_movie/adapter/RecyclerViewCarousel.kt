package com.example.kitkat_movie.adapter


import Carousel
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R

class RecyclerAdapterCarousel(val context: Context) : RecyclerView.Adapter<RecyclerAdapterCarousel.MyViewHolder>() {

    var CarouselList : List<Carousel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return CarouselList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint2)
            .error(R.drawable.blueprint2)

        Glide.with(holder.Rimg).applyDefaultRequestOptions(requestOptions).load(CarouselList[position].movie_img).into(holder.Rimg)

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setCarouselListItems(CarouselList: List<Carousel>){
        this.CarouselList = CarouselList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val Rimg: ImageView = itemView!!.findViewById(R.id.image)
    }
}