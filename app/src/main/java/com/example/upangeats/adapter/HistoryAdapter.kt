package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class HistoryAdapter: RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tray_items,parent,false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class HistoryViewHolder(val view: View): RecyclerView.ViewHolder(view){

}