package com.example.cse225_codes

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ETPPracticeUnitThreeDateTimePickerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_three_date_time_picker_one)

        val inputDate = findViewById<EditText>(R.id.etpInputDate1)
        val inputTime = findViewById<EditText>(R.id.etpInputTime1)
        val dateBtn = findViewById<Button>(R.id.etpDateButton1)
        val timeBtn = findViewById<Button>(R.id.etpTimeButton1)

        dateBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                inputDate.setText(formattedDate)
            }, year, month, day)

            datePickerDialog.show()
        }

        timeBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                val amPm = if (selectedHour < 12) "AM" else "PM"
                val hour12 = if (selectedHour % 12 == 0) 12 else selectedHour % 12
                val formattedTime = String.format("%02d:%02d %s", hour12, selectedMinute, amPm)
                inputTime.setText(formattedTime)
            }, hour, minute, false) // false means 12-hour format

            timePickerDialog.show()
        }
    }
}
