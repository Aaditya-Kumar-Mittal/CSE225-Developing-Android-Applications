package com.example.cse225_codes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1CustomToast1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_custom_toast1)

        // Get the toast button
        val toastBtn = findViewById<Button>(R.id.showToast5)

        toastBtn.setOnClickListener {

            // Retrieve ViewGroup of Custom Toast Layout using its id
            val toastLayout = findViewById<ViewGroup>(R.id.customToastLayout5)

            // Get an Inflater
            val toastInflater = layoutInflater

            // Inflate the custom toast layout, The inflate() method reads the layout XML file and creates the corresponding View objects.
            val toastView = toastInflater.inflate(R.layout.toast_custom_layout5, toastLayout, false)

            // Generate Toast
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_SHORT
            myToast.view = toastView
            myToast.show()
        }
    }
}