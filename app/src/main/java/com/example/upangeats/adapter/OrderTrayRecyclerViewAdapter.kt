package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.upangeats.R

class OrderTrayRecyclerViewAdapter : RecyclerView.Adapter<OrderTrayViewHolder>() {
    val order = listOf<String>("HEHE","OPO")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderTrayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tray_items,parent,false)
        return OrderTrayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return order.size
    }

    override fun onBindViewHolder(holder: OrderTrayViewHolder, position: Int) {
        val orderItem = order[position]
        return holder.bind(orderItem)
    }
}

class OrderTrayViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(order: String){
        val priceTextView = view.findViewById<TextView>(R.id.textView6)
        priceTextView.text = order
    }
}