package com.example.upangeats.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R

class FavoriteRecyclerViewAdapter:RecyclerView.Adapter<FavoriteRecyclerViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRecyclerViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewfavoriteitem,parent,false)
        return FavoriteRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: FavoriteRecyclerViewHolder, position: Int) {
        return holder.bind()
    }

}

class FavoriteRecyclerViewHolder( val view:View):RecyclerView.ViewHolder(view){
    fun bind(){

    }
}