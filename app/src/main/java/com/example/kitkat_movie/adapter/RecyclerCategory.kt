package com.example.kitkat_movie.adapter

import Category
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

class RecyclerAdapterCategory(val context: Context) : RecyclerView.Adapter<RecyclerAdapterCategory.MyViewHolder>() {

    var CategoryList : List<Category> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cate_card,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return CategoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title1.text = CategoryList[position].category

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setCategoryListItems(CategoryList: List<Category>){
        this.CategoryList = CategoryList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title1: TextView = itemView!!.findViewById(R.id.title1)
    }
}