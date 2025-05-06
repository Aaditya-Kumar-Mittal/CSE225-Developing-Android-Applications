package com.example.cse225_codes

import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ETPPracticeUnitThreeDatePickerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_three_date_picker_one)

        val datePicker1 = findViewById<DatePicker>(R.id.etpDatePicker1)
        val today = Calendar.getInstance()

        datePicker1.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
        { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            datePicker1.tooltipText = msg
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}