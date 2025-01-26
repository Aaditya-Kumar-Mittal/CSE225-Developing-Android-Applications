package com.example.cse225_codes

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneCustomToast2ToastLayout1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast2_toast_layout1)

        val showToast3 = findViewById<Button>(R.id.showToast3)

        showToast3.setOnClickListener{
            Toast(this).showCustomToast("This is a custom toast", this)
        }

    }
}