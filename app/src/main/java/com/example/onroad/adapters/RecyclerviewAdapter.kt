package com.example.onroad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onroad.R
import com.example.onroad.classes.Driver

class RecyclerviewAdapter(var driverList:ArrayList<Driver>):
RecyclerView.Adapter<RecyclerviewAdapter.DriverViewHolder>(){
    private lateinit var mlistener:onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int):String?
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mlistener = listener
    }

    class DriverViewHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.name)
        var carModel = itemView.findViewById<TextView>(R.id.car_model)
        var status = itemView.findViewById<TextView>(R.id.status)
        var ratingbar = itemView.findViewById<RatingBar>(R.id.ratingBar)
        var rating = itemView.findViewById<TextView>(R.id.rating)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)



            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return DriverViewHolder(view,mlistener)
    }

    override fun getItemCount(): Int {
        return driverList.size
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val currentDriver = driverList[position]
        holder.name.text = currentDriver.name
        holder.carModel.text = currentDriver.car
        holder.ratingbar.rating = currentDriver.rating
        holder.status.text = currentDriver.status
        holder.rating.text = currentDriver.rating.toString()
    }


}