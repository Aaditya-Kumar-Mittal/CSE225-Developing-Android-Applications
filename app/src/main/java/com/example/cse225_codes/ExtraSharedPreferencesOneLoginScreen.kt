package com.example.cse225_codes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityExtraSharedPreferencesOneLoginScreenBinding
import androidx.core.content.edit

class ExtraSharedPreferencesOneLoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityExtraSharedPreferencesOneLoginScreenBinding
    private val fileName = "login_details"

    // Function to store data in SharedPreferences
    private fun storeDataUsingSharedPreferences(username: String, password: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE)
        sharedPreferences.edit() {
            putString("username", username)
            putString("password", password)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraSharedPreferencesOneLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", "")
        val savedPassword = sharedPreferences.getString("password", "")

        // Restore data from SharedPreferences if available
        if (!savedUsername.isNullOrEmpty() && !savedPassword.isNullOrEmpty()) {
            binding.inputUsername1.setText(savedUsername)
            binding.inputPassword2.setText(savedPassword)
            binding.saveLoginDetails1.isChecked = true
        }

        // Handle login button click
        binding.loginButton1.setOnClickListener {
            val username = binding.inputUsername1.text.toString()
            val password = binding.inputPassword2.text.toString()
            val saveLoginDetails = binding.saveLoginDetails1.isChecked

            if (saveLoginDetails) {
                storeDataUsingSharedPreferences(username, password)
            }

            val intent = Intent(this, ExtraSharedPreferencesOneHomeScreen::class.java)
            startActivity(intent)
        }
    }
}
