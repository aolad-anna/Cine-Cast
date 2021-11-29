package com.example.kitkat_movie.others

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.kitkat_movie.R

class Preview : AppCompatActivity() {
    private var playUrl : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE);

        val intent1: Intent = intent

        var dataplayUrl = intent1.getStringExtra("playUrl")
        var datamovie_name = intent1.getStringExtra("movie_name")
        var datarelease_year = intent1.getStringExtra("release_year")
        var datamovie_img = intent1.getStringExtra("movie_img")
        var datamovie_img_lands = intent1.getStringExtra("movie_img_lands")
        var datareview_star = intent1.getStringExtra("review_star")
        var dataduration = intent1.getStringExtra("duration")
        var dataage = intent1.getStringExtra("age")

        var datastory = intent1.getStringExtra("story")
        var datadirector = intent1.getStringExtra("director")
        var datawriter = intent1.getStringExtra("writer")
        var datastar = intent1.getStringExtra("star")

        var datacategory_1 = intent1.getStringExtra("category_1")
        var datacategory_2 = intent1.getStringExtra("category_2")
        var datacategory_3 = intent1.getStringExtra("category_3")
        // Log.d("_show", data+"aaaaa")
        playUrl = dataplayUrl

        val TotalAffect: TextView = findViewById(R.id.textView16)
        TotalAffect.text = datamovie_name

        val TotalAffect1: TextView = findViewById(R.id.textView12)
        TotalAffect1.text = datarelease_year

        val TotalAffect110: TextView = findViewById(R.id.textView10)
        TotalAffect110.text = datareview_star

        val TotalAffect119a: TextView = findViewById(R.id.textView11)
        TotalAffect119a.text = dataduration

        val TotalAffect119b: TextView = findViewById(R.id.textView130)
        TotalAffect119b.text = dataage

        val TotalAffect11s9b: TextView = findViewById(R.id.textView13)
        TotalAffect11s9b.text = datacategory_1

        val TotalAffrect11s9b: TextView = findViewById(R.id.textView14)
        TotalAffrect11s9b.text = datacategory_2

        val TotalAfdfect11s9b: TextView = findViewById(R.id.textView15)
        TotalAfdfect11s9b.text = datacategory_3
        val TotaflAffrect11s9b: TextView = findViewById(R.id.textView18)
        TotaflAffrect11s9b.text = datastory

        val TotalAfedfect11s9b: TextView = findViewById(R.id.textView148)
        TotalAfedfect11s9b.text = datadirector

        //////////////////////////////////////
        val TotaflAffreect11s9b: TextView = findViewById(R.id.textView1487)
        TotaflAffreect11s9b.text = datawriter

        val TotalAfetdfect11s9b: TextView = findViewById(R.id.textView14287)
        TotalAfetdfect11s9b.text = datastar


        val TotalAffect111: ImageView = findViewById(R.id.imageView722)

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        Glide.with(this).applyDefaultRequestOptions(requestOptions).load(datamovie_img_lands)
            .into(TotalAffect111)

        val TotalAffect1110: ImageView = findViewById(R.id.imageView11)
        Glide.with(this).applyDefaultRequestOptions(requestOptions).load(datamovie_img)
            .into(TotalAffect1110)


        val mainLayout = findViewById<View>(R.id.floatingActionButton)

        mainLayout.setOnClickListener {
            val intent = Intent(this, PlayerView::class.java)
            intent.putExtra("playUrl", dataplayUrl)
            this.startActivity(intent)
        }


        val cButton: ImageButton = findViewById<View>(R.id.imageButton) as ImageButton
        cButton.setOnClickListener {
            super.onBackPressed();
        }
    }
}