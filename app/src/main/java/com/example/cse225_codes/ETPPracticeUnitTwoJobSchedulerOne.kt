package com.example.cse225_codes

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitTwoJobSchedulerOne : AppCompatActivity() {

    private lateinit var jobScheduler: JobScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_two_job_scheduler_one)


        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler

        val startBtn = findViewById<Button>(R.id.etpJobStart1)
        val stopBtn = findViewById<Button>(R.id.etpJobStop1)


        startBtn.setOnClickListener {

            val componentName = ComponentName(this, ETPPracticeUnitTwoJobSchedulerServiceOne::class.java)
            val jobBuilder = JobInfo.Builder(789, componentName)
                .setMinimumLatency(1000)
                .setOverrideDeadline(5000)
                .setPersisted(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(false)

            val resultCode = jobScheduler.schedule(jobBuilder.build())

            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Toast.makeText(this, "Job Scheduled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Job Scheduling Failed", Toast.LENGTH_SHORT).show()
            }
        }

        stopBtn.setOnClickListener {
            jobScheduler.cancel(789)
            Toast.makeText(this, "Job Cancelled", Toast.LENGTH_SHORT).show()

        }
    }
}