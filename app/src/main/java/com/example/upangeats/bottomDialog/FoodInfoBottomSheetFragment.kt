package com.example.upangeats.bottomDialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.upangeats.R
import com.example.upangeats.databinding.FragmentFoodInfoBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FoodInfoBottomSheetFragment : BottomSheetDialogFragment() {
  private lateinit var binding : FragmentFoodInfoBottomSheetBinding

    companion object {
        const val TAG = "ModalBottomSheet"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodInfoBottomSheetBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment



        return binding.root
    }


}