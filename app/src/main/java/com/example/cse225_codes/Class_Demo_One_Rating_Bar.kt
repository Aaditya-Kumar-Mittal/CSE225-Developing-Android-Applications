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

class Class_Demo_One_Rating_Bar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_rating_bar)

        var ratingBar1 = findViewById<RatingBar>(R.id.classRatingBar1)
        var ratingBar2 = findViewById<RatingBar>(R.id.classRatingBar2)
        var ratingButton1 = findViewById<Button>(R.id.ratingButton1)

        ratingButton1.setOnClickListener {
            val totalStars = "Total Stars: " + ratingBar1.numStars
            val rating = "Rating: " + ratingBar1.rating
            Toast.makeText(this, "$totalStars $rating".trimIndent(), Toast.LENGTH_SHORT).show()
        }

        ratingBar2.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val totalStars = "Total Stars: " + ratingBar.numStars
            val rating = "Rating: " + ratingBar.rating
            val feedback = findViewById<TextView>(R.id.textView1)
            feedback.text = "$totalStars $rating"
            Toast.makeText(this, "$totalStars $rating".trimIndent(), Toast.LENGTH_SHORT).show()
        }

    }
}