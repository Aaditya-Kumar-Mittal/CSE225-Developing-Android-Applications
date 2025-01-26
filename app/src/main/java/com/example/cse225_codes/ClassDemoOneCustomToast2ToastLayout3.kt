package com.example.cse225_codes

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneCustomToast2ToastLayout3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast2_toast_layout3)

        var showToast4 = findViewById<Button>(R.id.showToast4)
        showToast4.setOnClickListener {
            val customToastLayout = layoutInflater.inflate(R.layout.toast_custom_layout3, null)
            val customToast = Toast(this)
            customToast.view = customToastLayout
            customToast.setGravity(Gravity.CENTER, 0, 0)
            customToast.duration = Toast.LENGTH_LONG
            customToast.show()
        }
    }
}