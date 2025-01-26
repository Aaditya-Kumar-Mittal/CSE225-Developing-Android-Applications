package com.example.cse225_codes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneProgressBarTwo : AppCompatActivity() {
    private var i = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_progress_bar_two)

        // Import the XML Elements
        var progressBarTwo = findViewById<ProgressBar>(R.id.progressBarTwo)
        var textView = findViewById<TextView>(R.id.textView3)
        var btnShowTwo = findViewById<Button>(R.id.btnShowTwo)
        var btnResetTwo = findViewById<Button>(R.id.btnResetTwo)

        btnShowTwo.setOnClickListener {

            //Set the progress bar to visible
            progressBarTwo.visibility = View.VISIBLE

            // Get the progress bar value
            i = progressBarTwo.progress

            // Create a thread to update the progress bar
            Thread {

                // Update the progress bar value
                while (i < 100) {
                    i++

                    // Update the progress bar and text view
                    Handler(Looper.getMainLooper()).post {
                        progressBarTwo.progress = i
                        textView.text = "$i / ${progressBarTwo.max}"

                        // If the progress bar is 100, hide the progress bar
                        if (i == 100) {
                            progressBarTwo.visibility = View.INVISIBLE
                            Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    try {
                        //Try ensures the thread doesn't crash
                        Thread.sleep(100) // Updated sleep duration for smoother progress
                    } catch (e: InterruptedException) {
                        // If the thread is interrupted, print the stack trace
                        e.printStackTrace()
                    }
                }
            }.start() // Start the thread
        }

        btnResetTwo.setOnClickListener {
            i = 0
            progressBarTwo.progress = 0
            progressBarTwo.visibility = View.VISIBLE
            textView.text = "0 / ${progressBarTwo.max}"
        }

    }
}