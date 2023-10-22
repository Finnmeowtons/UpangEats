package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class MessageAdapter : RecyclerView.Adapter<MessageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        return holder.bind()
    }
}

class MessageViewHolder(val view : View): RecyclerView.ViewHolder(view){
    fun bind(){
    }
}