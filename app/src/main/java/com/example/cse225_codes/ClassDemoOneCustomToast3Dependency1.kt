package com.example.cse225_codes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.dmoral.toasty.Toasty

class ClassDemoOneCustomToast3Dependency1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_custom_toast3_dependency1)
    }


    // We assign this method to OnClick() in activity_main.xml
    fun showToast(v: View) {
        when (v.id) {
            // For Error type Toast
            R.id.button_error1 -> {
                Toasty.error(this, "This is an error Toast", Toast.LENGTH_SHORT).show()
            }
            // For Success type Toast
            R.id.button_success1 -> {
                Toasty.success(this, "This is a success Toast", Toast.LENGTH_SHORT).show()
            }
            // For Info type Toast
            R.id.button_info1 -> {
                Toasty.info(this, "This is an info Toast", Toast.LENGTH_SHORT).show()
            }
            // For Warning type Toast
            R.id.button_warning1 -> {
                Toasty.warning(this, "This is a warning Toast", Toast.LENGTH_SHORT).show()
            }
            // For Normal type Toast with an icon
            R.id.button_normal1 -> {
                Toasty.normal(
                    this, "This is a normal Toast", Toast.LENGTH_SHORT,
                    ContextCompat.getDrawable(this, R.drawable.ic_android_black_24dp)
                ).show()
            }
        }
    }
}