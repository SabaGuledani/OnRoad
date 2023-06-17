package com.example.onroad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onroad.R
import com.example.onroad.databinding.Fragment2Binding
import okhttp3.*


class Fragment2 : Fragment(R.layout.fragment_2) {
    private lateinit var binding:Fragment2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment2Binding.bind(view)

        val url = ""
        binding.summon.setOnClickListener {
            val request = Request.Builder()


        }




    }

}