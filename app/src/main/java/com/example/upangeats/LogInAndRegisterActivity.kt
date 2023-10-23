package com.example.upangeats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.upangeats.databinding.LoginRegisterMainBinding
import com.example.upangeats.viewModel.LogInActivityToMainActivityViewModel
import com.google.firebase.auth.FirebaseAuth

class LogInAndRegisterActivity : AppCompatActivity() {
    private lateinit var binding : LoginRegisterMainBinding
    private lateinit var buttonClickViewModel : LogInActivityToMainActivityViewModel
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginRegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            startActivity(Intent(this, MainActivity::class.java))
//        }

        buttonClickViewModel = ViewModelProvider(this)[LogInActivityToMainActivityViewModel::class.java]

        buttonClickViewModel.buttonClicked.observe(this) { clicked ->
            if (clicked) {
                startActivity(Intent(this, MainActivity::class.java))

                buttonClickViewModel.buttonClicked.value = false
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.LoginRegisterNavHost)
        return navController.navigateUp()
    }
}