package com.example.upangeats.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.upangeats.databinding.FragmentTextDialogBinding


class TextDialogFragment(private val confirmCallback: (String) -> Unit) : DialogFragment() {
    private lateinit var binding : FragmentTextDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextDialogBinding.inflate(inflater, container, false)

        binding.btnYes.setOnClickListener {
            confirmCallback("confirm")
            dismiss()
        }
        binding.btnNo.setOnClickListener {
            dismiss()
        }



        return binding.root
    }

}