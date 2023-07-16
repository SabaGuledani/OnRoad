package com.example.onroad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.SnapHelper
import com.example.onroad.R
import com.example.onroad.adapters.CarouselAdapter
import com.example.onroad.databinding.FragmentTourFullscreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FragmentTourFullscreen : Fragment(R.layout.fragment_tour_fullscreen) {
    private lateinit var binding: FragmentTourFullscreenBinding
    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var imgList:ArrayList<Int>
    private var isFavorite = false



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTourFullscreenBinding.bind(view)
//        val bottom_view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
//
//        bottom_view.visibility = View.GONE

        val recyclerview = binding.recyclerView


        recyclerview.layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())
        val snapHelper: SnapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(recyclerview)



        imgList = ArrayList()

        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        imgList.add(R.drawable.martvili)
        carouselAdapter = CarouselAdapter(imgList)


        recyclerview.adapter = carouselAdapter



        binding.favoriteButton.setOnClickListener {
            onFavoriteButtonClick()
        }

    }
    fun onFavoriteButtonClick() {
        isFavorite = !isFavorite
        if (isFavorite) {
            binding.favoriteButton.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            binding.favoriteButton.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }
}