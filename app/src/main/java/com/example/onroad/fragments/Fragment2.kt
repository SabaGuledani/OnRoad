package com.example.onroad.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.onroad.R
import com.example.onroad.adapters.CarouselAdapter
import com.example.onroad.databinding.Fragment2Binding
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import okhttp3.*


class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var binding:Fragment2Binding
    private lateinit var carouselAdapter:CarouselAdapter
    private lateinit var imgList:ArrayList<Int>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment2Binding.bind(view)


        val recyclerview = binding.carousel


        recyclerview.layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())
        val snapHelper: SnapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(recyclerview)



        imgList = ArrayList()

        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        carouselAdapter = CarouselAdapter(imgList)


        recyclerview.adapter = carouselAdapter




    }

}