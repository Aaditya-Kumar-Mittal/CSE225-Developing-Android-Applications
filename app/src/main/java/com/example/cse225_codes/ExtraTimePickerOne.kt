package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityExtraTimePickerOneBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class ExtraTimePickerOne : AppCompatActivity() {

    private lateinit var binding: ActivityExtraTimePickerOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraTimePickerOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showTimePicker1.setOnClickListener {
            showTimePicker()
        }
    }

    private fun showTimePicker() {
        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(10)
            .setTitleText("Select Time")
            .build()

        timePicker.show(supportFragmentManager, "TIME_PICKER")

        timePicker.addOnPositiveButtonClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute
            binding.selectTime1.text = String.format("%02d:%02d", hour, minute)
        }

        timePicker.addOnCancelListener {
            binding.selectTime1.text = "Cancelled"
        }
    }
}
