package com.example.cse225_codes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class ETPPracticeUnitFiveSharedPreferencesOne : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val fileName = "etp_shared_preferences_one"
    private val keyEmail = "email"
    private val keyPassword = "password"

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var saveBtn: Button
    private lateinit var returnBtn: Button
    private lateinit var clearBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_five_shared_preferences_one)

        emailEditText = findViewById(R.id.etpSharedPreferencesEmail1)
        passwordEditText = findViewById(R.id.etpSharedPreferencesPassword1)
        saveBtn = findViewById(R.id.etpSharedPreferencesSaveButton1)
        returnBtn = findViewById(R.id.etpSharedPreferencesReturnButton1)
        clearBtn = findViewById(R.id.etpSharedPreferencesClearButton1)

        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE)

        // Fetch from SharedPreferences existing data
        val savedEmail = sharedPreferences.getString(keyEmail, "")
        val savedPassword = sharedPreferences.getString(keyPassword, "")

        emailEditText.setText(savedEmail)
        passwordEditText.setText(savedPassword)

        saveBtn.setOnClickListener {
            saveData(it)
        }

        returnBtn.setOnClickListener {
            returnData(it)

        }

        clearBtn.setOnClickListener {
            clearData(it)
        }

    }

    private fun saveData(view: View?) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        sharedPreferences.edit() {
            putString(keyEmail, email)
            putString(keyPassword, password)
        }
    }

    private fun returnData(view: View?) {
        val savedEmail = sharedPreferences.getString(keyEmail, "")
        val savedPassword = sharedPreferences.getString(keyPassword, "")
        emailEditText.setText(savedEmail)
        passwordEditText.setText(savedPassword)
    }

    private fun clearData(view: View?) {
        sharedPreferences.edit() {
            clear()
        }
    }
}