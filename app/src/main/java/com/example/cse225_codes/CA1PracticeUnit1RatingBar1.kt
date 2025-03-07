package com.example.cse225_codes

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1RatingBar1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_rating_bar1)


        var caRate1 = findViewById<RatingBar>(R.id.caRatingBar1)
        var caRate2 = findViewById<RatingBar>(R.id.caRatingBar2)
        var caRateButton = findViewById<Button>(R.id.ratingButton2)

        caRateButton.setOnClickListener {
            val totalStars = caRate1.numStars
            val rating = caRate1.rating
            val feedback = findViewById<TextView>(R.id.ratingTextView1)
            val message = "$rating / $totalStars"
            feedback.text = message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        caRate2.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val totalStars = caRate2.numStars
            val rating = caRate2.rating
            val feedback = findViewById<TextView>(R.id.ratingTextView1)
            val message = "$rating / $totalStars"
            feedback.text = message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    }
}