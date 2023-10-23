package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.FavoriteRecyclerViewAdapter
import com.example.upangeats.adapter.FoodProductAdapter
import com.example.upangeats.databinding.FragmentStallFoodsBinding


class StallFoodsFragment : Fragment() {
    private lateinit var binding: FragmentStallFoodsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStallFoodsBinding.inflate(inflater, container, false)

//        binding.rvStallFoods.adapter = FoodProductAdapter()


        return binding.root
    }
}