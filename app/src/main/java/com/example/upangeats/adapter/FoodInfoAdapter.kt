package com.example.upangeats.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class FoodInfoAdapter() : RecyclerView.Adapter<FoodInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_product_list_item, parent, false)
        return FoodInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 50
    }

    override fun onBindViewHolder(holder: FoodInfoViewHolder, position: Int) {
        return holder.bind()
    }


}
class FoodInfoViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(){

    }

}
