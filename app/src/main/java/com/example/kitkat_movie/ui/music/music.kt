package com.example.kitkat_movie.ui.music

import Eraa
import Gen
import Lang
import Party
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitkat_movie.api.ApiClient
import com.example.kitkat_movie.R
import com.example.kitkat_movie.adapter.*
import com.example.kitkat_movie.api.ApiInterface
import com.example.kitkat_movie.api.ApiInterface2
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.databinding.MusicFragmentBinding
import com.example.kitkat_movie.model.*
import com.example.kitkat_movie.onboarding.NavBar
import com.example.kitkat_movie.others.Profile
import com.example.kitkat_movie.others.signin
import com.example.kitkat_movie.ui.home.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class music : Fragment() {

    private lateinit var musicViewModel: HomeViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    lateinit var recyclerViews: RecyclerView
    lateinit var recyclerAdapters: RecyclerAdapters

    lateinit var recyclerViewss: RecyclerView
    lateinit var recyclerAdapterss: RecyclerAdapterss

    lateinit var recyclerViewsss: RecyclerView
    lateinit var recyclerAdaptersss: RecyclerAdaptersss

    lateinit var recyclerViewssss: RecyclerView
    lateinit var recyclerAdapterssss: RecyclerAdapterssss


    private var _binding: MusicFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        musicViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = MusicFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        musicViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        val mProgressDialog = ProgressDialog(context)
        mProgressDialog.isIndeterminate = true
        mProgressDialog.setMessage("Loading...")
        mProgressDialog.setCancelable(false)
        mProgressDialog.setCanceledOnTouchOutside(false)
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



        recyclerView    = binding.root.findViewById(R.id.recyclerview)
        recyclerAdapter = RecyclerAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = recyclerAdapter

        val apiService = ApiClient.client!!.create(ApiInterface2::class.java)
        val call: Call<List<Movie>> = apiService.getMovies()
        call.enqueue(object : Callback<List<Movie>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                //if(response?.body() != null)

                if (response != null && mProgressDialog.isShowing) {

                    response.body()?.let { recyclerAdapter.setNotifyListItems(it) }
                    mProgressDialog.dismiss()
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Toast.makeText(context, "Something went wrong...", Toast.LENGTH_LONG).show();
            }
        })

        recyclerViews   = binding.root.findViewById(R.id.recyclerview1)
        recyclerAdapters = RecyclerAdapters(requireContext())
        recyclerViews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViews.adapter = recyclerAdapters

        val apiService1 = ApiClient.client!!.create(ApiInterface2::class.java)
        val call1: Call<List<Party>> = apiService1.getParty()
        call1.enqueue(object : Callback<List<Party>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Party>>, response: Response<List<Party>>) {

                //if(response?.body() != null)

                if (response != null) {

                    response.body()?.let { recyclerAdapters.setPartyListItems(it)}
                }
            }

            override fun onFailure(call: Call<List<Party>>, t: Throwable) {
                val pp =""
            }
        })

        recyclerViewss   = binding.root.findViewById(R.id.recyclerview2)
        recyclerAdapterss = RecyclerAdapterss(requireContext())
        recyclerViewss.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewss.adapter = recyclerAdapterss

        val apiService2 = ApiClient.client!!.create(ApiInterface2::class.java)
        val call2: Call<List<Lang>> = apiService2.getLang()
        call2.enqueue(object : Callback<List<Lang>>  {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Lang>> , response: Response<List<Lang>> ) {


                if (response != null) {

                    response.body()?.let { recyclerAdapterss.setLangListItems(it)}
                }
            }

            override fun onFailure(call: Call<List<Lang>> , t: Throwable) {
                val pp =""
            }
        })


        recyclerViewsss   = binding.root.findViewById(R.id.recyclerview3)
        recyclerAdaptersss = RecyclerAdaptersss(requireContext())
        recyclerViewsss.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewsss.adapter = recyclerAdaptersss

        val apiService3 = ApiClient.client!!.create(ApiInterface2::class.java)
        val call3: Call<List<Gen>> = apiService3.getGenres()
        call3.enqueue(object : Callback<List<Gen>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Gen>>, response: Response<List<Gen>>) {


                if (response != null) {
                    response.body()?.let { recyclerAdaptersss.setGenListItems(it)}
                }
            }

            override fun onFailure(call: Call<List<Gen>>, t: Throwable) {
                val pp =""
            }
        })

        recyclerViewssss   = binding.root.findViewById(R.id.recyclerview4)
        recyclerAdapterssss = RecyclerAdapterssss(requireContext())
        recyclerViewssss.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewssss.adapter = recyclerAdapterssss

        val apiService4 = ApiClient.client!!.create(ApiInterface2::class.java)
        val call4: Call<List<Eraa>> = apiService4.getErass()
        call4.enqueue(object : Callback<List<Eraa>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Eraa>>, response: Response<List<Eraa>>) {
                if (response != null) {

                    response.body()?.let { recyclerAdapterssss.setErListItems(it)}
                }
            }

            override fun onFailure(call: Call<List<Eraa>>, t: Throwable) {
                val pp =""
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}