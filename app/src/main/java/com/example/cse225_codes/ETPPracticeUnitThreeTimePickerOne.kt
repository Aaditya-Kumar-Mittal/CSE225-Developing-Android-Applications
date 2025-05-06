package com.example.cse225_codes

import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitThreeTimePickerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_three_time_picker_one)

        val timePicker = findViewById<TimePicker>(R.id.etpTimePicker1)
        val timeText = findViewById<TextView>(R.id.etpTimePickerText1)

        timePicker.setOnTimeChangedListener { _, hour, minute ->

            var getHour = hour
            var amOrPm = ""

            when {
                getHour == 0 -> {
                    getHour += 12
                    amOrPm = "AM"
                }

                getHour == 12 -> amOrPm = "PM"
                getHour > 12 -> {
                    getHour -= 12
                    amOrPm = "PM"
                }

                else -> amOrPm = "AM"
            }

            val formatHour = if (getHour < 10) "0$getHour" else getHour
            val getMinutes1 = if (minute < 10) "0$minute" else minute

            val message = "Time: $formatHour:$getMinutes1 $amOrPm"
            timeText.text = message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

    }
}