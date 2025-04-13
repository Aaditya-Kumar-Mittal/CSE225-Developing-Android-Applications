package com.example.cse225_codes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityExtraProgressBarsOneBinding
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.progressindicator.LinearProgressIndicator

class ExtraProgressBarsOne : AppCompatActivity() {

    private lateinit var binding: ActivityExtraProgressBarsOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtraProgressBarsOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Circular Indicator
        binding.circularProgressBar1.indicatorDirection = CircularProgressIndicator.INDICATOR_DIRECTION_COUNTERCLOCKWISE
        binding.circularProgressBar1.indicatorSize = 200
        binding.circularProgressBar1.trackThickness = 20
        binding.circularProgressBar1.isIndeterminate = true
        binding.circularProgressBar1.trackColor = getColor(R.color.red_500)
        // binding.circularProgressBar1.setIndicatorColor(getColor(R.color.red_500))

        // Setup Linear Progress Bar
        binding.linearProgressBar1.apply {
            isIndeterminate = true
            trackThickness = 20
            indicatorDirection = LinearProgressIndicator.INDICATOR_DIRECTION_RIGHT_TO_LEFT
            trackColor = getColor(R.color.slate_950)
            indeterminateAnimationType = LinearProgressIndicator.INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS
        }

        binding.showProgressBar1.setOnClickListener {
            binding.circularProgressBar1.visibility = CircularProgressIndicator.VISIBLE
            binding.linearProgressBar1.visibility = LinearProgressIndicator.VISIBLE
        }
    }
}
