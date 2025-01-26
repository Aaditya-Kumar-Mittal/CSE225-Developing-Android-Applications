package com.example.cse225_codes

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import io.github.muddz.styleabletoast.StyleableToast

class ClassDemoOneCustomToast1StyleableToast1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast1_styleable_toast1)

        val showToast1 = findViewById<Button>(R.id.showToast1)
        val showToast2 = findViewById<Button>(R.id.showToast2)

        showToast1.setOnClickListener{
            StyleableToast.makeText(
                this,
                "This is a custom toast",
                R.style.exampleToast1
            ).show()
        }

        // Display a custom toast using Builder
        showToast2.setOnClickListener {
            StyleableToast.Builder(this)
                .text("Hello world!")
                .textColor(getColor(R.color.lime_500)) // Simplified getColor
                .backgroundColor(getColor(R.color.slate_900)) // Simplified getColor
                .show()
        }

    }
}