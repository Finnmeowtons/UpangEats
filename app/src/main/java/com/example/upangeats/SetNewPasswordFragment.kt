package com.example.upangeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.upangeats.databinding.FragmentSetNewPasswordBinding
import com.google.firebase.auth.FirebaseAuth


class SetNewPasswordFragment : Fragment() {
    private lateinit var binding: FragmentSetNewPasswordBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSetNewPasswordBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        binding.imgbtnBackSetNewPassword.setOnClickListener {
            findNavController().navigate(R.id.action_setNewPasswordFragment_to_forgotPasswordFragment)
        }


        auth.sendPasswordResetEmail("emailAddress")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result
                }
            }

        return binding.root
    }
}