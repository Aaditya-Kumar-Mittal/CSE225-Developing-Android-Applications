package com.example.cse225_codes

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ClassDemoTwoJobService1 : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {

        Log.d("JobScheduler", "Job Started")

        val intent = Intent(this, ClassDemoTwoAlarmManager1AlarmBroadcast1::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 234, intent, PendingIntent.FLAG_MUTABLE)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000, pendingIntent)

        Toast.makeText(this, "Job Finished", Toast.LENGTH_SHORT).show()

        return true

    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Cancelled")
        return true

    }
}