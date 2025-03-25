package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse225_codes.databinding.ActivityExtraRatingBar1Binding

class ExtraRatingBar1 : AppCompatActivity() {

    private lateinit var binding: ActivityExtraRatingBar1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraRatingBar1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial rating (Default 0)
        binding.ratingView.setRating(0)

        // Set up the listener for rating changes

        binding.ratingView.setRatingChangeListener { previousRating, newRating ->
            // Update emotion view based on rating
            binding.emotionView.setRating(previousRating, newRating)

            // Change background gradient based on rating
            binding.gradientBackgroundView.changeBackground(previousRating, newRating)
        }
    }
}