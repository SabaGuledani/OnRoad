package com.example.onroad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onroad.R
import com.example.onroad.classes.Tour

class HorizontalRecyclerViewAdapter(var tourList:ArrayList<Tour>):
    RecyclerView.Adapter<HorizontalRecyclerViewAdapter.TourViewHolder>() {
    private lateinit var mlistener: HorizontalRecyclerViewAdapter.onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int):String?
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mlistener = listener
    }

    class TourViewHolder(itemView: View, listener: HorizontalRecyclerViewAdapter.onItemClickListener)
        :RecyclerView.ViewHolder(itemView){

        var tourName = itemView.findViewById<TextView>(R.id.tour_name)
        var tourDescription =  itemView.findViewById<TextView>(R.id.tour_description)
        var tourImage =  itemView.findViewById<ImageView>(R.id.tour_imageview)
        var carModel =  itemView.findViewById<TextView>(R.id.car_model)
        var ratingbar =  itemView.findViewById<RatingBar>(R.id.tour_ratingbar)
        var rating =  itemView.findViewById<TextView>(R.id.tour_rating)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }


        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TourViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_tour_horizontal,
        parent,false)
        return TourViewHolder(view,mlistener)

    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val currentTour = tourList[position]
        holder.tourName.text = currentTour.tourName
        holder.tourDescription.text = currentTour.tourDesctiprion
        holder.carModel.text = currentTour.ownerOperator?.car ?: "model"
        holder.ratingbar.rating = currentTour.tourRating
        holder.rating.text = currentTour.tourRating.toString()
        holder.tourImage.setImageResource(R.drawable.martvili)



    }

    override fun getItemCount(): Int {
        return tourList.size
    }


}