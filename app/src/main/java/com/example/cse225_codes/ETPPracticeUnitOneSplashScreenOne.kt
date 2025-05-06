package com.example.cse225_codes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETPPracticeUnitOneSplashScreenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_splash_screen_one)


        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, ETPPracticeUnitOneScrollViewOne::class.java)
                startActivity(intent)
                finish()
            }, 7000
        )
    }
}