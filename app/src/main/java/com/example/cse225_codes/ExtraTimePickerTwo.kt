package com.example.cse225_codes

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse225_codes.databinding.ActivityExtraTimePickerTwoBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ExtraTimePickerTwo : AppCompatActivity() {

    private lateinit var binding: ActivityExtraTimePickerTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraTimePickerTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showTimePicker2.setOnClickListener {
            showTimePicker()
        }
    }

    private fun showTimePicker() {
        val calendar2 = Calendar.getInstance()

        val timeListener = TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minute ->
            calendar2.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar2.set(Calendar.MINUTE, minute)

            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val selectedTime = timeFormat.format(calendar2.time)
            binding.selectTime2.text = selectedTime

        }

        val timePickerDialog = TimePickerDialog(this, timeListener, calendar2.get(Calendar.HOUR_OF_DAY), calendar2.get(Calendar.MINUTE), false)
        timePickerDialog.show()

    }
}