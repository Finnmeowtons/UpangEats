package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentFoodInfoBinding


class FoodInfoFragment : Fragment() {
    private lateinit var binding: FragmentFoodInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodInfoBinding.inflate(inflater, container, false)



        // Inflate the layout for this fragment
        return binding.root
    }

}