package com.example.cse225_codes

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ClassDemoOneCustomToast2ToastLayout2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast2_toast_layout2)

        val showToast4 = findViewById<Button>(R.id.showToast4)
        showToast4.setOnClickListener {
            // Pass the correct drawable resource ID here
            createCustomToast(
                this,
                layoutInflater,
                R.layout.toast_custom_layout2,
                R.drawable.img_8,  // Correct way to pass the drawable resource ID
                "This is a custom toast"
            )
        }
    }

    fun createCustomToast(
        context: Context,
        layoutInflater: LayoutInflater,
        customLayoutId: Int,
        imageResId: Int?,  // Image resource ID
        message: String,
    ) {
        // Inflate the supplied custom layout
        val layout = layoutInflater.inflate(customLayoutId, null)

        // Set up the custom layout's image
        val image = layout.findViewById<ImageView>(R.id.image)
        imageResId?.let {
            image.setImageResource(it)  // Set the image using the provided resource ID
        }

        // Set up the custom layout's text
        val text = layout.findViewById<TextView>(R.id.toast_text2)
        text.text = message

        // Create and configure the Toast
        val toast = Toast(context)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}
