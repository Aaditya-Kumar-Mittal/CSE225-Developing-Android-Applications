package com.example.cse225_codes

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit2AlarmManger1Main : AppCompatActivity() {

    private lateinit var alarmManager: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit2_alarm_manger1_main)

        // 1 -- Fetch XML Elements
        val startBtn = findViewById<Button>(R.id.alarmStartBtn2)
        val repeatBtn = findViewById<Button>(R.id.alarmRepeatBtn2)
        val cancelBtn = findViewById<Button>(R.id.alarmCancelBtn2)
        val alarmTimeValue = findViewById<EditText>(R.id.alarmTimeValue1)

        // 2 -- Create the intent for broadcast file
        val intent = Intent(this, CA1PracticeUnit2AlarmManger1Broadcast::class.java)

        // 3 -- Create pending intent
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // 4 -- Set the alarm
        startBtn.setOnClickListener {
            val i = alarmTimeValue.text.toString().toInt()
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent)
            Toast.makeText(this, "Alarm set for $i seconds", Toast.LENGTH_SHORT).show()
        }

        repeatBtn.setOnClickListener {
            val i = alarmTimeValue.text.toString().toInt()
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (i * 1000).toLong(), pendingIntent)
            Toast.makeText(this, "Alarm Repetition set for $i seconds", Toast.LENGTH_SHORT).show()
        }

        cancelBtn.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}