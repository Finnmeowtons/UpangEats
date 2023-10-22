package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentStallReviewBinding

class StallReviewFragment : Fragment() {
    private lateinit var binding: FragmentStallReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStallReviewBinding.inflate(inflater, container, false)



        return binding.root
    }
}