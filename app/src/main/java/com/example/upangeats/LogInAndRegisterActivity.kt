package com.example.upangeats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class LogInAndRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_register_main)
           //jomel jovellanos
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.LoginRegisterNavHost)
        return navController.navigateUp()
    }
}