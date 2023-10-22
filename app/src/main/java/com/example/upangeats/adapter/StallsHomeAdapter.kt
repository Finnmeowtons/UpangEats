package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class StallsHomeAdapter : RecyclerView.Adapter<StallsHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StallsHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stall_home_item, parent, false)
        return StallsHomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: StallsHomeViewHolder, position: Int) {
        return holder.bind()
    }
}

class StallsHomeViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    fun bind(){

    }
}