package com.example.upangeats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.upangeats.databinding.FragmentRegisterBinding
import com.example.upangeats.dataclass.UserInformation
import com.example.upangeats.db.UserInformationDatabaseHelper
import com.example.upangeats.dialog.TextDialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var userInfoDB: UserInformationDatabaseHelper
    private var validateEmail: Boolean = false
    private var validateName: Boolean = false
    private var validatePhoneNumber: Boolean = false
    private var validatePassword: Boolean = false
    private var validateConfirmPassword: Boolean = false
    private lateinit var firebaseAuth: FirebaseAuth


    private lateinit var email: String
    private lateinit var name: String
    private lateinit var phoneNumber: String
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        userInfoDB = UserInformationDatabaseHelper(this.requireContext())


        binding.apply {

            imgbtnBackSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

            btnSignUpSignUp.setOnClickListener {

                val emailEditTextValue = etEmailSignUp.text?.trim()
                if (emailEditTextValue?.contains(".up@phinmaed.com") == true) {
                    validateEmail = true
                    etEmailLayout.error = null
                } else if (
                    emailEditTextValue?.contains("gmail.com") == true ||
                    emailEditTextValue?.contains("yahoo.com") == true
                ) {
                    validateEmail = false
                    etEmailLayout.error = "Only UPANG accounts are allowed!"
                } else if (emailEditTextValue?.isEmpty() == true) {
                    etEmailLayout.error = "Text field is empty!"
                    validateEmail = false
                } else {
                    etEmailLayout.error = "Invalid email!"
                    validateEmail = false
                }

                val nameEditTextValue = etFullNameSignUp.text?.trim()
                if (nameEditTextValue?.length!! <= 6) {
                    etFullNameLayout.error = "Input at least 6 characters!"
                    validateName = false
                } else if (nameEditTextValue.isEmpty()) {
                    etFullNameLayout.error = "Text field is empty!"
                    validateName = false
                } else {
                    etFullNameLayout.error = null
                    validateName = true
                }

                val phoneNumberEditTextValue = etPhoneNumberSignUp.text?.trim()
                if (phoneNumberEditTextValue?.length!! == 0) {
                    etPhoneNumberLayout.error = null
                    validatePhoneNumber = true
                } else if (phoneNumberEditTextValue.length != 10) {
                    etPhoneNumberLayout.error = " "
                    validatePhoneNumber = false
                } else if (phoneNumberEditTextValue.isEmpty()) {
                    etPhoneNumberLayout.error = "Empty!"
                    validatePhoneNumber = false
                } else if (!phoneNumberEditTextValue.startsWith("9")) {
                    etPhoneNumberLayout.error = "Invalid!"
                    validatePhoneNumber = false
                } else {
                    etPhoneNumberLayout.error = null
                    validatePhoneNumber = true
                }

                val passwordEditTextValue = etPasswordSignUp.text?.trim()
                if (passwordEditTextValue?.length!! <= 7) {
                    etPasswordLayout.error = "Input at least 8 characters!"
                    validatePassword = false
                } else if (passwordEditTextValue.isEmpty()) {
                    etPasswordLayout.error = "Text field is empty!"
                    validatePassword = false
                } else {
                    etPasswordLayout.error = null
                    validatePassword = true
                }

                val confirmPasswordEditTextValue = etRepeatPasswordSignUp.text?.trim()
                if (confirmPasswordEditTextValue?.toString() != passwordEditTextValue.toString()) {
                    etConfirmPasswordLayout.error = "Password does not match"
                    validateConfirmPassword = false
                } else {
                    etConfirmPasswordLayout.error = null
                    validateConfirmPassword = true
                }

                if (validateEmail && validateName && validatePhoneNumber && validatePassword && validateConfirmPassword) {


                    val email = emailEditTextValue.toString()
                    val name = etFullNameSignUp.text.toString()
                    val phoneNumber = etPhoneNumberSignUp.text.toString()
                    val password = etPasswordSignUp.text.toString()




                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Confirm Sign Up")
                        .setMessage("Are you sure the credentials you have inputted are correct?")
                        .setNegativeButton("Go back") { dialog, which ->

                        }
                        .setOnDismissListener {
                        }
                        .setPositiveButton("Confirm") { dialog, which ->

                            firebaseAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener() { taskAuth ->
                                    if (taskAuth.isSuccessful) {
                                        val firebaseUserId = firebaseAuth.uid.toString()
                                        val signUpValue = UserInformation(1, name, email, phoneNumber, firebaseUserId)
                                        // Sign in success, update UI with the signed-in user's information
                                        when (userInfoDB.signUp(signUpValue)) {
                                            "Success" -> {

                                                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                                            }

                                            "Failed to sign up" -> {
                                                Toast.makeText(
                                                    requireContext(),
                                                    "Authentication failed..",
                                                    Toast.LENGTH_SHORT,
                                                ).show()
                                            }
                                        }
                                    } else if (taskAuth.exception is FirebaseAuthUserCollisionException){
                                        etEmailLayout.error = "Email already taken!"
                                    } else {
                                        Log.e("MyTag", "${taskAuth.exception}")
                                    }

                                }

                        }
                        .show()
                }
            }
        }

        return binding.root
    }

}