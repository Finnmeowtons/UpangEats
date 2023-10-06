package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentStallsBinding

class StallsFragment : Fragment() {
    private lateinit var binding : FragmentStallsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding = FragmentStallsBinding.inflate(inflater, container, false)



        return binding.root
    }
}