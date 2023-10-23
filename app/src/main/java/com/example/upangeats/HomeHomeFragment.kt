package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upangeats.adapter.HomeHomeRecyclerViewAdapter
import com.example.upangeats.databinding.FragmentHomeHomeBinding
import com.example.upangeats.dialog.ReportAProblemDialogFragment

class HomeHomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeHomeBinding.inflate(inflater, container, false)
        binding.homeHomeRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.homeHomeRecyclerView.adapter = HomeHomeRecyclerViewAdapter()

        return binding.root
    }
}