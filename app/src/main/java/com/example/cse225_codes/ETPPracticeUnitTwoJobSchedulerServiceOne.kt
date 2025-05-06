package com.example.cse225_codes

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ETPPracticeUnitTwoJobSchedulerServiceOne : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {

        Log.d("ETP Job Scheduler", "Job has been started")

        val intent = Intent(this, ETPPracticeUnitTwoAlarmManagerBroadcastOne::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this, 789, intent, PendingIntent.FLAG_IMMUTABLE)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000, pendingIntent)

        Toast.makeText(this, "Job has been finished", Toast.LENGTH_SHORT).show()

        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("ETP JobScheduler", "Job Cancelled")

        return true
    }
}