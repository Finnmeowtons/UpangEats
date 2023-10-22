package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class FoodProductAdapter : RecyclerView.Adapter<FoodProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_product_list_item,parent,false)
        return FoodProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: FoodProductViewHolder, position: Int) {
//        val productNameOne = holder.view.findViewById<TextView>(R.id.tvFoodProduct3)
//        val productNameTwo = holder.view.findViewById<TextView>(R.id.tvFoodProduct4)
        return holder.bind()

    }
}
class FoodProductViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind() {
        view.setOnClickListener {

        }
    }
}
