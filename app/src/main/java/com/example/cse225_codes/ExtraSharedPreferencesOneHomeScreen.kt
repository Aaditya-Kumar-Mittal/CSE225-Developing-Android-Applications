package com.example.cse225_codes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityExtraSharedPreferencesOneHomeScreenBinding
import androidx.core.content.edit

class ExtraSharedPreferencesOneHomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityExtraSharedPreferencesOneHomeScreenBinding

    private val fileName = "login_details"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraSharedPreferencesOneHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE)

        val username = sharedPreferences.getString("username", "")
        binding.displayUsername1.text = "Welcome, $username!"

        binding.logoutButton1.setOnClickListener {
            sharedPreferences.edit() { clear() }

            val intent = Intent(this, ExtraSharedPreferencesOneLoginScreen::class.java)
            startActivity(intent)
        }

    }
}