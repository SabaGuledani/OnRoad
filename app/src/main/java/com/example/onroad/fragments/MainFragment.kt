package com.example.onroad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onroad.R
import com.example.onroad.adapters.RecyclerviewAdapter
import com.example.onroad.classes.TourOperator
import com.example.onroad.databinding.FragmentMainBinding
import com.google.firebase.database.*


class MainFragment : Fragment(R.layout.fragment_main) {
        private lateinit var binding:FragmentMainBinding
        private lateinit var tourOperatorList:ArrayList<TourOperator>
        private lateinit var dbref: DatabaseReference
        private lateinit var driverRecyclerviewAdapter: RecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context)
        tourOperatorList = ArrayList()

        dbref = FirebaseDatabase.getInstance().getReference()
        driverRecyclerviewAdapter = RecyclerviewAdapter(tourOperatorList)
        recyclerview.adapter = driverRecyclerviewAdapter

        dbref.child("drivers").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                tourOperatorList.clear()
                for (postsnapshot in snapshot.children) {
                    val driverobject = postsnapshot.getValue(TourOperator::class.java)
                    if (driverobject != null) {
                        tourOperatorList.add(driverobject)

                    }
                }
                driverRecyclerviewAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })




        driverRecyclerviewAdapter.setOnItemClickListener(object :
        RecyclerviewAdapter.onItemClickListener{
            override fun onItemClick(position: Int): String? {
                return "araferi"
            }

        })









    }



}