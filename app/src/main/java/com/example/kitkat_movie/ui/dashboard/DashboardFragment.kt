package com.example.kitkat_movie.ui.dashboard

import Tv
import Tv1
import Tv2
import Tv3
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitkat_movie.R
import com.example.kitkat_movie.adapter.RecyclerAdapterTv
import com.example.kitkat_movie.adapter.RecyclerAdapterTv1
import com.example.kitkat_movie.adapter.RecyclerAdapterTv2
import com.example.kitkat_movie.adapter.RecyclerAdapterTv3
import com.example.kitkat_movie.api.ApiClient2
import com.example.kitkat_movie.api.ApiInterface2
import com.example.kitkat_movie.api.SharedPrefManager
import com.example.kitkat_movie.databinding.FragmentDashboardBinding
import com.example.kitkat_movie.onboarding.NavBar
import com.example.kitkat_movie.others.Profile
import com.example.kitkat_movie.others.signin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    lateinit var recyclerViewTv: RecyclerView
    lateinit var recyclerAdapterTv: RecyclerAdapterTv

    lateinit var recyclerViewTv1: RecyclerView
    lateinit var recyclerAdapterTv1: RecyclerAdapterTv1

    lateinit var recyclerViewTv2: RecyclerView
    lateinit var recyclerAdapterTv2: RecyclerAdapterTv2

    lateinit var recyclerViewTv3: RecyclerView
    lateinit var recyclerAdapterTv3: RecyclerAdapterTv3

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        })


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


        recyclerViewTv    = binding.root.findViewById(R.id.card_tv)
        recyclerAdapterTv = RecyclerAdapterTv(requireContext())
        recyclerViewTv.layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        recyclerViewTv.adapter = recyclerAdapterTv


        val apiService2 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call2: Call<List<Tv>> = apiService2.getTv()
        call2.enqueue(object : Callback<List<Tv>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Tv>>, response: Response<List<Tv>>) {

                //if(response?.body() != null)

                if (response != null) {

                    response.body()?.let { recyclerAdapterTv.setTvItems(it) }
                }
            }

            override fun onFailure(call: Call<List<Tv>>, t: Throwable) {
                val pp =""
            }
        })


        recyclerViewTv1    = binding.root.findViewById(R.id.card_tv1)
        recyclerAdapterTv1 = RecyclerAdapterTv1(requireContext())
        recyclerViewTv1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewTv1.adapter = recyclerAdapterTv1


        val apiService3 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call3: Call<List<Tv1>> = apiService3.getTv1()
        call3.enqueue(object : Callback<List<Tv1>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Tv1>>, response: Response<List<Tv1>>) {

                //if(response?.body() != null)

                if (response != null) {

                    response.body()?.let { recyclerAdapterTv1.setTv1Items(it) }
                }
            }

            override fun onFailure(call: Call<List<Tv1>>, t: Throwable) {
                val pp =""
            }
        })


        recyclerViewTv2    = binding.root.findViewById(R.id.card_tv2)
        recyclerAdapterTv2 = RecyclerAdapterTv2(requireContext())
        recyclerViewTv2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewTv2.adapter = recyclerAdapterTv2


        val apiService4 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call4: Call<List<Tv2>> = apiService4.getTv2()
        call4.enqueue(object : Callback<List<Tv2>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Tv2>>, response: Response<List<Tv2>>) {

                //if(response?.body() != null)

                if (response != null) {

                    response.body()?.asReversed().let {
                        if (it != null) {
                            recyclerAdapterTv2.setTv2Items(it)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Tv2>>, t: Throwable) {
                val pp =""
            }
        })


        recyclerViewTv3    = binding.root.findViewById(R.id.card_tv3)
        recyclerAdapterTv3 = RecyclerAdapterTv3(requireContext())
        recyclerViewTv3.layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        recyclerViewTv3.adapter = recyclerAdapterTv3


        val apiService0 = ApiClient2.client2!!.create(ApiInterface2::class.java)
        val call0: Call<List<Tv3>> = apiService0.getTv3()
        call0.enqueue(object : Callback<List<Tv3>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Tv3>>, response: Response<List<Tv3>>) {

                //if(response?.body() != null)

                if (response != null) {

                    response.body()?.let { recyclerAdapterTv3.setTv3Items(it) }
                }
            }

            override fun onFailure(call: Call<List<Tv3>>, t: Throwable) {
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