package com.example.kitkat_movie.ui.series

import AllMovies
import AllMovies1
import BanglaMovie
import Carousel
import HindiMovie
import TamilMovie
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitkat_movie.R
import com.example.kitkat_movie.adapter.*
import com.example.kitkat_movie.api.ApiClient2
import com.example.kitkat_movie.api.ApiInterface2
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.databinding.SeriesFragmentBinding
import com.example.kitkat_movie.model.DataModel
import com.example.kitkat_movie.onboarding.NavBar
import com.example.kitkat_movie.others.Profile
import com.example.kitkat_movie.others.signin
import com.example.kitkat_movie.ui.home.HomeFragment
import com.example.kitkat_movie.ui.home.HomeViewModel
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class series : Fragment() {

    private lateinit var seriesViewModel: HomeViewModel
    private var _binding: SeriesFragmentBinding? = null

    lateinit var carouselRecyclerview: RecyclerView
    lateinit var carouselRecyclerAdapter: RecyclerAdapterCarousel

    lateinit var recyclerViewAllMovie: RecyclerView
    lateinit var recyclerAdapterAllMovie: RecyclerAdapterAllMovie

    lateinit var recyclerViewAllMovie1: RecyclerView
    lateinit var recyclerAdapterAllMovie1: RecyclerAdapterAllMovie1

    lateinit var recyclerViewHindiMovie: RecyclerView
    lateinit var recyclerAdapterHindiMovie: RecyclerAdapterHindiMovie

    lateinit var recyclerViewBanglaMovie: RecyclerView
    lateinit var recyclerAdapterBanglaMovie: RecyclerAdapterBanglaMovie

    lateinit var recyclerViewTamilMovie: RecyclerView
    lateinit var recyclerAdapterTamilMovie: RecyclerAdapterTamilMovie

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        seriesViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = SeriesFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        seriesViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        val mProgressDialog = ProgressDialog(context)
        mProgressDialog.isIndeterminate = true
        mProgressDialog.setMessage("Loading...")
        mProgressDialog.show()

        val LButton = binding.root.findViewById<View>(R.id.imageView822) as ImageView
        LButton.setOnClickListener { view ->
            if(SharedPrefManager.getInstance(requireContext()).isLoggedIn){
                val intent = Intent(context, Profile::class.java)
                startActivity(intent)
            }
            else
            {
                val intent = Intent(view.context, signin::class.java)
                view.context.startActivity(intent)
            }
        }

        val HButton = binding.root.findViewById<View>(R.id.imageView722) as ImageView
        HButton.setOnClickListener { view ->
            val intent = Intent(view.context, NavBar::class.java)
            view.context.startActivity(intent)
        }

        val carouselRecyclerview = binding.root.findViewById<CarouselRecyclerview>(R.id.recycler)

        carouselRecyclerAdapter = RecyclerAdapterCarousel(requireContext())

        carouselRecyclerview.adapter = carouselRecyclerAdapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)


        val carouselLayoutManager = carouselRecyclerview.getCarouselLayoutManager()
        val currentlyCenterPosition = carouselRecyclerview.getSelectedPosition()


        val apiService3 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call3: Call<List<Carousel>> = apiService3.getCarousel()
        call3.enqueue(object : Callback<List<Carousel>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Carousel>>, response: Response<List<Carousel>>) {

                //if(response?.body() != null)

                if (response != null && mProgressDialog.isShowing) {
                    response.body()?.let { carouselRecyclerAdapter.setCarouselListItems(it)}
                    carouselLayoutManager.scrollToPosition(1)
                    mProgressDialog.dismiss()
                }
            }

            override fun onFailure(call: Call<List<Carousel>>, t: Throwable) {
                val pp =""
            }
        })

        recyclerViewAllMovie    = binding.root.findViewById(R.id.card_re)
        recyclerAdapterAllMovie = RecyclerAdapterAllMovie(requireContext())
        recyclerViewAllMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewAllMovie.adapter = recyclerAdapterAllMovie


        val apiService2 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call2: Call<List<AllMovies>> = apiService2.getAllMovies()
        call2.enqueue(object : Callback<List<AllMovies>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<AllMovies>>, response: Response<List<AllMovies>>) {

                //if(response?.body() != null)

                if (response != null) {
                    response.body()?.let { recyclerAdapterAllMovie.setAllMoviesListListItems(it) }
                    //_binding!!.progress1500.visibility=View.GONE
                }
            }

            override fun onFailure(call: Call<List<AllMovies>>, t: Throwable) {
                val pp =""
            }
        })

        recyclerViewAllMovie1    = binding.root.findViewById(R.id.card_re1)
        recyclerAdapterAllMovie1 = RecyclerAdapterAllMovie1(requireContext())
        recyclerViewAllMovie1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewAllMovie1.adapter = recyclerAdapterAllMovie1


        val apiService22 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call22: Call<List<AllMovies1>> = apiService22.getAllMovies1()
        call22.enqueue(object : Callback<List<AllMovies1>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<AllMovies1>>, response: Response<List<AllMovies1>>) {

                //if(response?.body() != null)

                if (response != null) {
                    response.body()?.let { recyclerAdapterAllMovie1.setAllMoviesList1Items(it) }
                    //_binding!!.progress1600.visibility=View.GONE
                }
            }

            override fun onFailure(call: Call<List<AllMovies1>>, t: Throwable) {
                val pp =""
            }
        })


        recyclerViewHindiMovie    = binding.root.findViewById(R.id.hindi)
        recyclerAdapterHindiMovie = RecyclerAdapterHindiMovie(requireContext())
        recyclerViewHindiMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewHindiMovie.adapter = recyclerAdapterHindiMovie


        val apiService4 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call4: Call<List<HindiMovie>> = apiService4.getHindiMovie()
        call4.enqueue(object : Callback<List<HindiMovie>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<HindiMovie>>, response: Response<List<HindiMovie>>) {

                //if(response?.body() != null)

                if (response != null) {
                    response.body()?.let { recyclerAdapterHindiMovie.setHindiMoviesListItems(it) }
                    //_binding!!.progress1900.visibility=View.GONE
                }
            }

            override fun onFailure(call: Call<List<HindiMovie>>, t: Throwable) {
                val pp =""
            }
        })

        recyclerViewBanglaMovie    = binding.root.findViewById(R.id.bangla)
        recyclerAdapterBanglaMovie = RecyclerAdapterBanglaMovie(requireContext())
        recyclerViewBanglaMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewBanglaMovie.adapter = recyclerAdapterBanglaMovie

        val apiService5 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call5: Call<List<BanglaMovie>> = apiService5.getBanglaMovie()
        call5.enqueue(object : Callback<List<BanglaMovie>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<BanglaMovie>>, response: Response<List<BanglaMovie>>) {

                //if(response?.body() != null)

                if (response != null) {
                    response.body()?.let { recyclerAdapterBanglaMovie.setBanglaMoviesListItems(it) }
                    //_binding!!.progress2000.visibility=View.GONE
                }
            }

            override fun onFailure(call: Call<List<BanglaMovie>>, t: Throwable) {
                val pp =""
            }
        })


        recyclerViewTamilMovie    = binding.root.findViewById(R.id.tamil)
        recyclerAdapterTamilMovie = RecyclerAdapterTamilMovie(requireContext())
        recyclerViewTamilMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewTamilMovie.adapter = recyclerAdapterTamilMovie

        val apiService6 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call6: Call<List<TamilMovie>> = apiService6.getTamilMovie()
        call6.enqueue(object : Callback<List<TamilMovie>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<TamilMovie>>, response: Response<List<TamilMovie>>) {

                //if(response?.body() != null)

                if (response != null) {
                    response.body()?.let { recyclerAdapterTamilMovie.setTamilMoviesListItems(it) }
                    //_binding!!.progress2100.visibility=View.GONE
                }
            }

            override fun onFailure(call: Call<List<TamilMovie>>, t: Throwable) {
                Log.e("dadosApiError","erro no retorno " + t.message)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}