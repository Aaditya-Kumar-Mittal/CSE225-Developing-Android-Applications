package com.example.cse225_codes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1SplashScreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_splash_screen1)

        // This is the splash screen main file
        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start the main activity
            // In the second parameter, put the name of the activity you want to open after splash screen.
            val intent = Intent(this, CA1PracticeUnit1CustomToast1::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}