package com.example.cse225_codes

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ClassDemoTwoJobScheduler1 : AppCompatActivity() {

    private lateinit var jobScheduler: JobScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_two_job_scheduler1)

        // Initialize JobScheduler
        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        val startJob = findViewById<CardView>(R.id.startJob1)
        val cancelJob = findViewById<CardView>(R.id.cancelJob1)

        startJob.setOnClickListener {
            val componentName = ComponentName(this, ClassDemoTwoJobService1::class.java)
            val jobBuilder = JobInfo.Builder(123, componentName)
                .setMinimumLatency(1000) // Wait at least 1 seconds
                .setOverrideDeadline(30000) // Execute within 30 seconds
                .setPersisted(true) // Persist after reboot
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) // Requires network
                .setRequiresCharging(false) // Charging not required

            val resultCode = jobScheduler.schedule(jobBuilder.build())
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Toast.makeText(this, "Job Scheduled Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Job Scheduling Failed", Toast.LENGTH_SHORT).show()
            }

        }

        cancelJob.setOnClickListener {
            jobScheduler.cancel(123) // Cancel the job with ID 123
            Toast.makeText(this, "Job Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}
