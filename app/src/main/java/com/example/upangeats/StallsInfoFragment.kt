package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.databinding.FragmentStallsInfoBinding


class StallsInfoFragment : Fragment() {
    private lateinit var binding: FragmentStallsInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStallsInfoBinding.inflate(inflater, container, false)
        binding.stallsInfoRecyclerView.layoutManager= LinearLayoutManager(this.context)




        return binding.root
    }
}


