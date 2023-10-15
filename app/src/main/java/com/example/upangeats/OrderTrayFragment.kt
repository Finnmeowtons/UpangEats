package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.OrderTrayRecyclerViewAdapter
import com.example.upangeats.databinding.FragmentOrderTrayBinding

class OrderTrayFragment : Fragment() {
    private lateinit var binding: FragmentOrderTrayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentOrderTrayBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = OrderTrayRecyclerViewAdapter()


        return binding.root
    }
}