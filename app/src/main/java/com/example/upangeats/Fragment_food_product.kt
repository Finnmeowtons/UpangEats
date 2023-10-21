package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.databinding.FragmentFoodProduct2Binding

class Fragment_food_product : Fragment() {
    private lateinit var binding: FragmentFoodProduct2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodProduct2Binding.inflate(inflater, container, false)
        binding.foodProductRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.foodProductRecyclerView.adapter = foodProductAdapter()

        return binding.root
    }
}

