package com.example.cse225_codes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class ClassDemoOneProgressBarThreeUserInput : AppCompatActivity() {

    // Declare the variables for the progress bars
    lateinit var progressBar1: ProgressBar
    lateinit var progressBar2: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_progress_bar_three_user_input)

        // Import the XML Elements
        progressBar1 = findViewById<ProgressBar>(R.id.progressBarThree1)
        progressBar2 = findViewById<ProgressBar>(R.id.progressBarThree2)
        var textView = findViewById<TextView>(R.id.textView4)
        var btnShowThree = findViewById<Button>(R.id.btnShowThree)
        var btnResetThree = findViewById<Button>(R.id.btnResetThree)
        var input = findViewById<EditText>(R.id.userInput1)

        // Set the progress bar to invisible
        progressBar1.visibility = ProgressBar.INVISIBLE
        progressBar2.visibility = ProgressBar.INVISIBLE

        btnShowThree.setOnClickListener {
            // Set the progress bar to visible
            progressBar1.visibility = ProgressBar.VISIBLE
            progressBar2.visibility = ProgressBar.VISIBLE

            // Get the progress bar value
            var i = progressBar1.progress

            // Create a thread to update the progress bar
            Thread {
                // Update the progress bar value
                while (i < 100) {
                    i++
                    Handler(Looper.getMainLooper()).post {
                        progressBar1.progress = i
                        progressBar2.progress = i
                        textView.text = "$i / ${progressBar1.max}"
                        if (i == 100) {
                            progressBar1.visibility = ProgressBar.INVISIBLE
                            progressBar2.visibility = ProgressBar.INVISIBLE
                            Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    try {
                        //Try ensures the thread doesn'
                        Thread.sleep(100) // Updated sleep duration for smoother progress
                    } catch (e: InterruptedException) {
                        // If the thread is interrupted, print the stack trace
                        e.printStackTrace()
                    }
                }
            }.start()
        }

        btnResetThree.setOnClickListener {
            progressBar1.progress = 0
            progressBar2.progress = 0
            progressBar1.visibility = ProgressBar.INVISIBLE
            progressBar2.visibility = ProgressBar.INVISIBLE
            textView.text = "0 / ${progressBar1.max}"
        }

        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                progressBar1.visibility = View.VISIBLE
                var str = s.toString()
                if (s != null) {
                    if (str.isEmpty()) {
                        progressBar1.progress = 0
                    } else if (str.length == 1) {
                        progressBar1.progress = 10
                    } else if (str.length == 2) {
                        progressBar1.progress = 20
                    } else if (str.length == 3) {
                        progressBar1.progress = 30
                    } else if (str.length == 4) {
                        progressBar1.progress = 40
                    } else if (str.length == 5) {
                        progressBar1.progress = 50
                    } else if (str.length == 6) {
                        progressBar1.progress = 60
                    } else if (str.length == 7) {
                        progressBar1.progress = 70
                    } else if (str.length == 8) {
                        progressBar1.progress = 80
                    } else if (str.length == 9) {
                        progressBar1.progress = 90
                    } else if (str.length == 10) {
                        progressBar1.progress = 100
                        Toast.makeText(applicationContext, "You reach at 10 characters", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }
}