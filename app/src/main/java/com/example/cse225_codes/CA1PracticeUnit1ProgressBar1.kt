package com.example.cse225_codes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1ProgressBar1 : AppCompatActivity() {

    lateinit var progressBar51: ProgressBar
    lateinit var progressBar52: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_progress_bar1)

        // Get the XML Elements
        progressBar51 = findViewById<ProgressBar>(R.id.progressBar51)
        progressBar52 = findViewById<ProgressBar>(R.id.progressBar52)
        var startBtn = findViewById<Button>(R.id.startProgressBtn1)
        var resetBtn = findViewById<Button>(R.id.resetProgressButton1)
        var progressValue = findViewById<TextView>(R.id.progressValue1)
        var progressInput = findViewById<EditText>(R.id.progressInput1)

        // Set the Visibility of Progress Bar to Invisible
        progressBar51.visibility = ProgressBar.INVISIBLE
        progressBar52.visibility = ProgressBar.INVISIBLE

        startBtn.setOnClickListener {

            val inputText = progressInput.text.toString()

            // Ensure the input is not empty or invalid
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pValue = inputText.toIntOrNull() ?: 0  // Default to 0 if conversion fails

            // Set the Visibility of Progress Bar to Visible
            progressBar51.visibility = ProgressBar.VISIBLE
            progressBar52.visibility = ProgressBar.VISIBLE

            // Set the Progress Bar Value
            var i = pValue
            progressBar51.progress = i

            // Create a thread to update the progress bar
            Thread {
                // Update the progress bar value
                while (i < 100) {
                    i++
                    Handler(Looper.getMainLooper()).post {
                        progressBar51.progress = i
                        progressBar52.progress = i
                        progressValue.text = "$i/${progressBar51.max}"
                        if (i == 100) {
                            progressBar51.visibility = ProgressBar.INVISIBLE
                            progressBar52.visibility = ProgressBar.INVISIBLE
                            Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    try {
                        // Try ensures the thread doesn't crash
                        Thread.sleep(100) // Updated sleep duration for smoother progress
                    } catch (e: InterruptedException) {
                        // If the thread is interrupted, print the stack trace
                        e.printStackTrace()

                    }
                }
            }.start()
        }

        resetBtn.setOnClickListener {
            progressBar51.progress = 0
            progressBar52.progress = 0
            progressBar51.visibility = ProgressBar.INVISIBLE
            progressBar52.visibility = ProgressBar.INVISIBLE
            progressValue.text = "0/${progressBar51.max}"
        }
    }
}