package com.example.upangeats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.upangeats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostController = supportFragmentManager
//            .findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
//        navController = navHostController.navController

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.mainNavContainer)
        return navController.navigateUp()

        //testcomment123
    }
}