package com.example.upangeats

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.upangeats.databinding.FragmentLoginBinding
import com.example.upangeats.db.UserInformationDatabaseHelper
import com.example.upangeats.viewModel.LogInActivityToMainActivityViewModel
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userInfoDB: UserInformationDatabaseHelper
    private lateinit var buttonClickViewModel: LogInActivityToMainActivityViewModel
    private lateinit var firebaseAuth: FirebaseAuth

    private var isEmailValid = false
    private var isPasswordValid = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //Move to another fragment by clicking a button
        userInfoDB = UserInformationDatabaseHelper(this.requireContext())
        firebaseAuth = FirebaseAuth.getInstance()
        buttonClickViewModel =
            ViewModelProvider(requireActivity())[LogInActivityToMainActivityViewModel::class.java]

        binding.apply {

            tvSignUpHere.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }

            tvForgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
            }

            btnLogIn.setOnClickListener {

                val emailEditText = etEmailLogIn.text?.trim()
                if (emailEditText.isNullOrEmpty()) {
                    isEmailValid = false
                    etEmailLayout.error = "Text field is empty!"
                } else {
                    etEmailLayout.error = null
                    isEmailValid = true
                }

                val passwordEditText = etPasswordSignIn.text?.trim()
                if (passwordEditText.isNullOrEmpty()) {
                    isPasswordValid = false
                    etPasswordLayout.error = "Text field is empty!"
                } else {
                    etPasswordLayout.error = null
                    isPasswordValid = true
                }

                if (isEmailValid && isPasswordValid) {
                    val email = emailEditText.toString()
                    val password = passwordEditText.toString()
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(requireActivity()) { task ->
                            if (task.isSuccessful) {

                                buttonClickViewModel.buttonClicked.value = true
                            } else {
                                etPasswordLayout.error = "Invalid email or password!"
                                etEmailLayout.error = "Invalid email or password!"
                                // If sign in fails, display a message to the user.
                            }
                        }
                }

            }

            imgbtnBackSignUp.setOnClickListener {
                requireActivity().finish()
            }


        }
        return binding.root
    }


}