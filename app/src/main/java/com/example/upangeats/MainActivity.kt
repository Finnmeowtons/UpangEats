package com.example.upangeats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.upangeats.databinding.ActivityMainBinding
import com.example.upangeats.viewModel.SharedViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedViewModel : SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.mainNavContainer)
        return navController.navigateUp()
    }
}