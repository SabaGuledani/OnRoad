package com.example.onroad.fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onroad.R
import com.example.onroad.adapters.HorizontalRecyclerViewAdapter
import com.example.onroad.adapters.RecyclerviewAdapter
import com.example.onroad.classes.Tour
import com.example.onroad.classes.TourOperator
import com.example.onroad.databinding.FragmentExploreBinding
import com.google.firebase.database.*


class FragmentExplore : Fragment(R.layout.fragment_explore) {
    private lateinit var binding:FragmentExploreBinding
    private lateinit var tourList:ArrayList<TourOperator>
    private lateinit var dbref: DatabaseReference
    private lateinit var recyclerviewAdapter: RecyclerviewAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExploreBinding.bind(view)
        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)

        tourList = ArrayList()
        dbref = FirebaseDatabase.getInstance().getReference()
        recyclerviewAdapter = RecyclerviewAdapter(tourList)

        recyclerview.adapter = recyclerviewAdapter
        dbref.child("drivers").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tourList.clear()

                for (postsnapshot in snapshot.children) {
                    val driverobject = postsnapshot.getValue(TourOperator::class.java)
                    if (driverobject != null) {
                        tourList.add(driverobject)


                    }
                }
                recyclerviewAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "check your internet connection", Toast.LENGTH_SHORT).show()
            }


        })


        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.textField.editableText as? AutoCompleteTextView)?.setAdapter(adapter)

        recyclerviewAdapter.setOnItemClickListener(object :
            RecyclerviewAdapter.onItemClickListener{
            override fun onItemClick(position: Int): String? {
                return "araferi"
            }

        })
    }

}