package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class HistoryAdapter: RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item,parent,false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        return holder.bind()
    }
}

class HistoryViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(){

    }
}