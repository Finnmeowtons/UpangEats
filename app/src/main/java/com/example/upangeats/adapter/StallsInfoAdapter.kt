package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class StallsInfoAdapter : RecyclerView.Adapter<StallsInfoViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): StallsInfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val stallsInfoListItem = layoutInflater.inflate(R.layout.stalls_info_list_item,parent,false)
        return StallsInfoViewHolder((stallsInfoListItem))
    }

    override fun getItemCount(): Int {
    return 5
    }

    override fun onBindViewHolder(holder: StallsInfoViewHolder, position: Int) {
    holder.textView1.text = "sdsadsad"
    holder.textView2.text = "dasdasdasdasd"
    }
}

class StallsInfoViewHolder(val view:View) : RecyclerView.ViewHolder(view){
    var textView1 = view.findViewById<TextView>(R.id.tvFoodProduct3)
    val textView2 = view.findViewById<TextView>(R.id.tvFoodProduct4)

}