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

class ClassDemoOneProgressBarOne : AppCompatActivity() {
    private var i = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_progress_bar_one)

        val progressBarOne = findViewById<ProgressBar>(R.id.progressBar)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val textView = findViewById<TextView>(R.id.textView2)

        btnShow.setOnClickListener {
            progressBarOne.visibility = View.VISIBLE
            i = progressBarOne.progress
            Thread {
                while (i < 100) {
                    i++
                    Handler(Looper.getMainLooper()).post {
                        progressBarOne.progress = i
                        textView.text = "$i / ${progressBarOne.max}"
                        if (i == 100) {
                            progressBarOne.visibility = View.INVISIBLE
                            Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                    try {
                        Thread.sleep(100) // Updated sleep duration for smoother progress
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start() // Start the thread
        }

        btnReset.setOnClickListener {
            i = 0
            progressBarOne.progress = 0
            progressBarOne.visibility = View.VISIBLE
            textView.text = "0 / ${progressBarOne.max}"
        }
    }
}
