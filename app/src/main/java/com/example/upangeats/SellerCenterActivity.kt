package com.example.upangeats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.upangeats.databinding.ActivitySellerCenterBinding
import com.example.upangeats.viewModel.SharedViewModel

class SellerCenterActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySellerCenterBinding
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellerCenterBinding.inflate(layoutInflater)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        setContentView(binding.root)
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_anim,
                R.anim.exit_anim
            )
            .replace(R.id.frameLayoutSeller, SellerCenterFragment())
            .commit()
    }

    //Handling of the system ui back button and managing the navigation states
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    private fun onBackPressedMethod() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            sharedViewModel.selectedProduct.value = null
        }
    }
}