package com.example.onroad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onroad.R
import com.example.onroad.adapters.RecyclerviewAdapter
import com.example.onroad.classes.Driver
import com.example.onroad.databinding.FragmentMainBinding
import com.google.firebase.database.*
import kotlin.reflect.typeOf


class MainFragment : Fragment(R.layout.fragment_main) {
        private lateinit var binding:FragmentMainBinding
        private lateinit var driverList:ArrayList<Driver>
        private lateinit var dbref: DatabaseReference
        private lateinit var driverRecyclerviewAdapter: RecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context)
        driverList = ArrayList()

        dbref = FirebaseDatabase.getInstance().getReference()
        driverRecyclerviewAdapter = RecyclerviewAdapter(driverList)
        recyclerview.adapter = driverRecyclerviewAdapter

        dbref.child("drivers").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                driverList.clear()
                for (postsnapshot in snapshot.children) {
                    val driverobject = postsnapshot.getValue(Driver::class.java)
                    if (driverobject != null) {
                        driverList.add(driverobject)
                        var temp = driverobject.rating
                        Toast.makeText(context, temp::class.toString(), Toast.LENGTH_SHORT).show()
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