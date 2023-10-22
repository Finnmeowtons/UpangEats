package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R
import com.example.upangeats.Stalls

class StallsAdapter(
    private val stallsAdapter:List<Stalls>,
    private val clickListener:(Stalls)-> Unit
    ) : RecyclerView.Adapter<StallsViewHolder>(){
    val stallList = listOf<Stalls>(
        Stalls( "Aljon","borger"),
        Stalls("Jose","pancit"),
        Stalls("Menard","canton"),
        Stalls("Lord", "turon"),
        Stalls("Jeremy", "tissue"),
        Stalls("Neil", "icecream"),
        Stalls("Julius", "pu")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StallsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.stalls_list_item, parent, false   )
        return StallsViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return stallList.size
    }

    override fun onBindViewHolder(holder: StallsViewHolder, position: Int) {
            val stalls = stallList[position]
            holder.bind(stalls,clickListener)


    }
}

class StallsViewHolder(val view:View):RecyclerView.ViewHolder(view){
    fun bind(stalls: Stalls, clickListener:(Stalls)-> Unit) {

        view.setOnClickListener {
            clickListener(stalls)
        }


    }


}