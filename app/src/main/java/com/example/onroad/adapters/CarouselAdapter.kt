package com.example.onroad.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.onroad.R
import com.google.android.material.imageview.ShapeableImageView


class CarouselAdapter(var imglist:ArrayList<Int>):RecyclerView.Adapter<CarouselAdapter.ImageViewHolder>()
    {
        class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            var img  = itemView.findViewById<ImageView>(R.id.tour_imageview)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_main,
                parent,false)
            return ImageViewHolder(view)
        }

        override fun getItemCount(): Int {
            return imglist.size
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            var currentImg = imglist[position]
            var list = (1..6).toList()
            when (list.random()){
                1->holder.img.setImageResource(R.drawable.martvili)
                2->holder.img.setImageResource(R.drawable.stone)
                3->holder.img.setImageResource(R.drawable.stone_2)
                4->holder.img.setImageResource(R.drawable.tbilisi)
                5->holder.img.setImageResource(R.drawable.old_tblisi)
                6->holder.img.setImageResource(R.drawable.tblisi_2)
            }

        }

    }
