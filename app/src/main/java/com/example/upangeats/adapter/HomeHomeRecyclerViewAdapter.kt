package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R


class HomeHomeRecyclerViewAdapter : RecyclerView.Adapter<HomeHomeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_home_list_item,parent,false)
        return HomeHomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: HomeHomeViewHolder, position: Int) {
        val productNameOne = holder.view.findViewById<TextView>(R.id.tvBreakfastMeals)
        return holder.bind()
    }

}

class HomeHomeViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(){

    }

}