package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class stallsAdapter : RecyclerView.Adapter<stallsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): stallsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.stalls_list_item, parent, false   )
        return stallsViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: stallsViewHolder, position: Int) {

    }
}

class stallsViewHolder(val view:View):RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvStalls)


}