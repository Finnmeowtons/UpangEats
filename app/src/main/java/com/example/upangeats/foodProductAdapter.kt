package com.example.upangeats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class foodProductAdapter : RecyclerView.Adapter<FoodProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val foodProductListItem = layoutInflater.inflate(R.layout.food_product_list_item,parent, false  )
        return FoodProductViewHolder(foodProductListItem)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: FoodProductViewHolder, position: Int) {
        holder.textView3.text = "dsadasda"
        holder.textView4.text = "sdasdasdsa"

    }
}
class FoodProductViewHolder(val view: View):RecyclerView.ViewHolder(view){
    var textView3 = view.findViewById<TextView>(R.id.tvFoodProduct3)
    val textView4 = view.findViewById<TextView>(R.id.tvFoodProduct4)
}
