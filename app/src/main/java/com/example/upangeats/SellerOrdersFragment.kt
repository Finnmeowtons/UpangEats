package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentSellerOrdersBinding

class SellerOrdersFragment : Fragment() {
    private lateinit var binding: FragmentSellerOrdersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSellerOrdersBinding.inflate(inflater, container, false)



        // Inflate the layout for this fragment
        return binding.root
    }

}