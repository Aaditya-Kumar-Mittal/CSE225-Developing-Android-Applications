package com.example.cse225_codes

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneCustomToast2ToastLayout4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast2_toast_layout4)


        // Get the button from XML Layout
        val toastButton = findViewById<Button>(R.id.showToast5)

        // Set a click listener on the button
        toastButton.setOnClickListener {

            // Retrieve the ViewGroup using the Resource Id
            val toastContainer = findViewById<ViewGroup>(R.id.customToastLayout4)

            // OR val vg: ViewGroup = findViewById(R.id.customToastLayout4)

            // Get an Inflater
            val toastInflater = layoutInflater

            // Inflate the custom toast layout, The inflate() method reads the layout XML file and creates the corresponding View objects.
            val toastView = toastInflater.inflate(R.layout.toast_custom_layout4, toastContainer, false)

            // OR val toastView : View = toastInflater.inflate(R.layout.toast_custom_layout4, vg)

            // Extract the text view from the inflated view
            val toastTextView = toastView.findViewById<TextView>(R.id.textView2)

            val toastImageView = toastView.findViewById<ImageView>(R.id.imageView1)

            val generateToast = Toast(applicationContext)

            generateToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)

            generateToast.duration = Toast.LENGTH_SHORT

            generateToast.view = toastView

            generateToast.show()
        }
    }
}