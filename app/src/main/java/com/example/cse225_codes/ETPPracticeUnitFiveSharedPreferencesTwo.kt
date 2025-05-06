package com.example.cse225_codes

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class ETPPracticeUnitFiveSharedPreferencesTwo : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val fileName = "etp_shared_preferences_two"
    private val keyText = "text"
    private val keySwitch = "switch"

    private lateinit var text: TextView
    private lateinit var editText: EditText
    private lateinit var switchInput: SwitchCompat
    private lateinit var applyBtn: Button
    private lateinit var saveBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_five_shared_preferences_two)

        text = findViewById(R.id.etpSharedPreferencesText1)
        editText = findViewById(R.id.etpSharedPreferencesText2)
        switchInput = findViewById(R.id.etpSharedPreferencesSwitch1)
        applyBtn = findViewById(R.id.etpSharedPreferencesApplyButton1)
        saveBtn = findViewById(R.id.etpSharedPreferencesSaveButton2)

        applyBtn.setOnClickListener {
            applyText()
        }

        saveBtn.setOnClickListener {
            saveDate()
        }

        loadData()


    }

    private fun applyText() {
        val textValue = editText.text.toString()
        text.text = textValue
    }

    private fun saveDate() {
        sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE)
        val textValue = editText.text.toString()
        val switchValue = switchInput.isChecked
        sharedPreferences.edit().apply {
            putString(keyText, textValue)
            putBoolean(keySwitch, switchValue)
            apply()
        }
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE)
        val savedText = sharedPreferences.getString(keyText, "")
        val savedSwitch = sharedPreferences.getBoolean(keySwitch, false)
        text.text = savedText
        switchInput.isChecked = savedSwitch
    }
}