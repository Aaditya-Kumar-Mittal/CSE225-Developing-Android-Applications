package com.example.cse225_codes


import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitOneRatingBarOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_rating_bar_one)

        val rB1 = findViewById<RatingBar>(R.id.etpRating1)
        val rB2 = findViewById<RatingBar>(R.id.etpRating2)
        val rbT1 = findViewById<TextView>(R.id.etpRatingText1)
        val rbB1 = findViewById<Button>(R.id.etpRatingButton1)

        rbB1.setOnClickListener {
            val totalStars = rB1.numStars
            val newRating = rB1.rating
            rbT1.text = "Rating: $newRating/$totalStars"
        }

        rB2.setOnRatingBarChangeListener { _, rating, _ ->
            val totalStars = rB1.numStars
            Toast.makeText(this, "Rating: $rating/$totalStars", Toast.LENGTH_SHORT).show()
        }
    }
}