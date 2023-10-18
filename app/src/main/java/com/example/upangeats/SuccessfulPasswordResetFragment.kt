package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.databinding.FragmentSuccessfulPasswordResetBinding


class SuccessfulPasswordResetFragment : Fragment() {
    private lateinit var binding: FragmentSuccessfulPasswordResetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSuccessfulPasswordResetBinding.inflate(inflater, container, false)



        return binding.root
    }
}