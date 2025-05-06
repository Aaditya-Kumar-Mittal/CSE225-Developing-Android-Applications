package com.example.cse225_codes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitOneProgressBarOne : AppCompatActivity() {
    private var progressVal = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_progress_bar_one)

        val progressBar1 = findViewById<ProgressBar>(R.id.etpPB1)
        val progressBar2 = findViewById<ProgressBar>(R.id.etpPB2)
        val startBtn1 = findViewById<Button>(R.id.etpStartProgress1)
        val resetBtn1 = findViewById<Button>(R.id.etpResetProgress1)
        val progressText = findViewById<TextView>(R.id.etpProgressText)

        progressBar1.max = 100
        progressBar1.visibility = View.INVISIBLE
        progressBar2.visibility = View.INVISIBLE

        startBtn1.setOnClickListener {
            progressBar1.visibility = View.VISIBLE
            progressBar2.visibility = View.VISIBLE
            progressBar1.progress = progressVal

            Thread {
                while (progressVal < 100) {
                    progressVal += 1

                    handler.post {
                        progressBar1.progress = progressVal
                        progressText.text = "$progressVal%"
                        if (progressVal == 100) {
                            progressBar1.visibility = View.INVISIBLE
                            progressBar2.visibility = View.INVISIBLE
                        }
                    }

                    try {
                        Thread.sleep(100) // Slows down progress for visibility
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }

        resetBtn1.setOnClickListener {
            progressVal = 0
            progressBar1.progress = progressVal
            progressText.text = "$progressVal%"
            progressBar1.visibility = View.INVISIBLE
            progressBar2.visibility = View.INVISIBLE
        }
    }
}
