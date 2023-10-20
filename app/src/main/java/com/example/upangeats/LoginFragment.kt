package com.example.upangeats

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.upangeats.databinding.FragmentLoginBinding
import com.example.upangeats.viewModel.LogInActivityToMainActivityViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var buttonClickViewModel : LogInActivityToMainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //Move to another fragment by clicking a button

        buttonClickViewModel = ViewModelProvider(requireActivity())[LogInActivityToMainActivityViewModel::class.java]
       
        binding.tvSignUpHere.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        binding.btnLogIn.setOnClickListener {
            buttonClickViewModel.buttonClicked.value = true
        }

        return binding.root
    }



}