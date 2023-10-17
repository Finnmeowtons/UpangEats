package com.example.upangeats

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.stallsAdapter
import com.example.upangeats.databinding.FragmentStallsBinding

class StallsFragment : Fragment() {
    private lateinit var binding : FragmentStallsBinding
    val stallList = listOf<Stalls>(
        Stalls( "Aljon","Aljon"),
        Stalls("Jose","Jose"),
        Stalls("Menard","Menard"),
        Stalls("Lord", "Lord"),
        Stalls("Jeremy", "Jeremy"),
        Stalls("Neil", "Neil"),
        Stalls("Julius", "Julius")
    )



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding = FragmentStallsBinding.inflate(inflater, container, false)
        binding.stallsrecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.stallsrecyclerView.adapter = stallsAdapter(
            stallList,
        ) { selectedItem: Stalls ->
            listItemClicked(selectedItem)
        }





        return binding.root
    }

    private fun listItemClicked(stalls: Stalls){
        Toast.makeText(
            this.context,
            "Stall of ${stalls.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}