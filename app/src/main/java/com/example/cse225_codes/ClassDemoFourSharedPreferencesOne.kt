package com.example.cse225_codes

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFourSharedPreferencesOneBinding
import androidx.core.content.edit

class ClassDemoFourSharedPreferencesOne : AppCompatActivity() {

    private lateinit var binding: ActivityClassDemoFourSharedPreferencesOneBinding
    private lateinit var sharedPreferences1: SharedPreferences

    private val sharedPreferenceName1 = "mySharedPreference1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityClassDemoFourSharedPreferencesOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferences
        sharedPreferences1 = getSharedPreferences(sharedPreferenceName1, MODE_PRIVATE)

        // Load saved data on startup
        retrieveData()

        // Set up button click listeners
        binding.saveButton1.setOnClickListener {
            saveData()
        }

        binding.clearButton1.setOnClickListener {
            clearData()
        }

        binding.getButton1.setOnClickListener {
            retrieveData()
        }
    }

    private fun saveData() {
        val firstName = binding.firstNameInput1.text.toString()
        val lastName = binding.lastNameInput1.text.toString()

        // Save data in SharedPreferences
        sharedPreferences1.edit {
            putString("firstName", firstName)
            putString("lastName", lastName)
        }
    }

    private fun clearData() {
        // Clear SharedPreferences
        sharedPreferences1.edit {
            clear()
        }
        binding.firstNameInput1.setText("")
        binding.lastNameInput1.setText("")
    }

    private fun retrieveData() {
        binding.firstNameInput1.setText(sharedPreferences1.getString("firstName", ""))
        binding.lastNameInput1.setText(sharedPreferences1.getString("lastName", ""))
    }
}
