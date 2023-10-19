package com.example.upangeats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.upangeats.R
import com.example.upangeats.Stalls

class stallsAdapter(
    private val stallsAdapter:List<Stalls>,
    private val clickListener:(Stalls)-> Unit
    ) : RecyclerView.Adapter<stallsViewHolder>(){
    val stallList = listOf<Stalls>(
        Stalls( "Aljon","borger"),
        Stalls("Jose","pancit"),
        Stalls("Menard","canton"),
        Stalls("Lord", "turon"),
        Stalls("Jeremy", "tissue"),
        Stalls("Neil", "icecream"),
        Stalls("Julius", "pu")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): stallsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.stalls_list_item, parent, false   )
        return stallsViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return stallList.size
    }

    override fun onBindViewHolder(holder: stallsViewHolder, position: Int) {
            val stalls = stallList[position]
            holder.bind(stalls,clickListener)


    }
}

class stallsViewHolder(val view:View):RecyclerView.ViewHolder(view){
    fun bind(stalls: Stalls, clickListener:(Stalls)-> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvStalls)
        myTextView.text = stalls.name

        view.setOnClickListener {
            clickListener(stalls)
        }
    }


}