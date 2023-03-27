package com.example.onroad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.onroad.R
import com.example.onroad.adapters.HorizontalRecyclerViewAdapter
import com.example.onroad.adapters.RecyclerviewAdapter
import com.example.onroad.classes.Tour
import com.example.onroad.classes.TourOperator
import com.example.onroad.databinding.FragmentMainBinding
import com.example.onroad.databinding.ItemCustomFixedSizeLayoutBinding
import com.google.firebase.database.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.model.CarouselType
import org.imaginativeworld.whynotimagecarousel.utils.setImage


class MainFragment : Fragment(R.layout.fragment_main) {
        private lateinit var binding:FragmentMainBinding
        private lateinit var tourListPopular:ArrayList<Tour>
        private lateinit var tourListLong:ArrayList<Tour>
        private lateinit var dbref: DatabaseReference
        private lateinit var horizontalRecyclerViewAdapter:HorizontalRecyclerViewAdapter
        private lateinit var horizontalRecyclerViewAdapterLong:HorizontalRecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.carousel.registerLifecycle(viewLifecycleOwner)

        val recyclerview = binding.recyclerView
        val recyclerviewLong = binding.recyclerView2
        recyclerview.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        recyclerviewLong.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        tourListPopular = ArrayList()
        tourListLong = ArrayList()

        dbref = FirebaseDatabase.getInstance().getReference()
        horizontalRecyclerViewAdapter = HorizontalRecyclerViewAdapter(tourListPopular)
        horizontalRecyclerViewAdapterLong = HorizontalRecyclerViewAdapter(tourListLong)

        recyclerview.adapter = horizontalRecyclerViewAdapter
        recyclerviewLong.adapter = horizontalRecyclerViewAdapterLong

//        binding.button.setOnClickListener {
//            var list = ArrayList<String>()
//            list.add("araperi")
//            var operator = TourOperator("asda","name","surname","12","12","email",list,"country","caar",1,3.0F)
//            var tour = Tour(operator,"lorem ipsum aafsgnsdgnsdfogjsoidgnmsokgnsoikgd","tour name",3.0F)
//
//
//            dbref.child("tours").push().setValue(tour)
//        }

        dbref.child("tours").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                tourListPopular.clear()
                tourListLong.clear()
                for (postsnapshot in snapshot.children) {
                    val driverobject = postsnapshot.getValue(Tour::class.java)
                    if (driverobject != null) {
                        tourListPopular.add(driverobject)
                        tourListLong.add(driverobject)

                    }
                }
                horizontalRecyclerViewAdapter.notifyDataSetChanged()
                horizontalRecyclerViewAdapterLong.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

        // Custom view
        binding.carousel.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding {
                return ItemCustomFixedSizeLayoutBinding.inflate(layoutInflater, parent, false)
            }

            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayoutBinding

                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP

                    setImage(item, R.drawable.martvili)
                }
            }
        }


        val list = mutableListOf<CarouselItem>()
        list.add(CarouselItem(imageDrawable = R.drawable.stone))
        list.add(CarouselItem(imageDrawable = R.drawable.stone_2))
        list.add(CarouselItem(imageDrawable = R.drawable.martvili))
        binding.carousel.setData(list)




        horizontalRecyclerViewAdapterLong.setOnItemClickListener(object :
        HorizontalRecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int): String? {
                return "araferi"
            }

        })
        horizontalRecyclerViewAdapter.setOnItemClickListener(object :
            HorizontalRecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int): String? {
                return "araferi"
            }

        })











    }



}