package com.example.cse225_codes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitOneCustomToastOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_custom_toast_one)

        val showToast = findViewById<Button>(R.id.showToast6)
        showToast.setOnClickListener {
            val toastView = findViewById<ViewGroup>(R.id.customToastLayout6)
            val inflater = layoutInflater
            val toastFile = inflater.inflate(R.layout.toast_custom_layout_6, toastView, false)
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_SHORT
            myToast.view = toastFile
            myToast.show()
        }

    }
}