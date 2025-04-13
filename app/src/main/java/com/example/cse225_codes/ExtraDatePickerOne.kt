package com.example.cse225_codes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse225_codes.databinding.ActivityExtraDatePickerOneBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ExtraDatePickerOne : AppCompatActivity() {

    private lateinit var binding: ActivityExtraDatePickerOneBinding
    private val calendar1 = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraDatePickerOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDatePicker1.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val datePickerDialog =
            DatePickerDialog(this, { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate: String = dateFormat.format(selectedDate.time)
                binding.selectDate1.text = formattedDate
            }, calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }
}