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

class ETPPracticeUnitTwoAlarmManagerOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_two_alarm_manager_one)

        val slot = findViewById<EditText>(R.id.etpAlarmSlot1)
        val startBtn = findViewById<Button>(R.id.etpAlarmStart1)
        val repeatBtn = findViewById<Button>(R.id.etpAlarmRepeat1)
        val stopBtn = findViewById<Button>(R.id.etpAlarmCancel1)

        // Make an Alarm Manager
        var alarmManager: AlarmManager
        var intent = Intent(this, ETPPracticeUnitTwoAlarmManagerBroadcastOne::class.java)
        var pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        startBtn.setOnClickListener {
            val timeSlot = slot.text.toString().toInt()
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (timeSlot * 1000), pendingIntent)
            Toast.makeText(this, "Alarm Set for $timeSlot seconds", Toast.LENGTH_SHORT).show()
        }

        repeatBtn.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (slot.text.toString().toInt() * 1000).toLong(), pendingIntent)
            Toast.makeText(this, "Alarm Set for every ${slot.text} seconds", Toast.LENGTH_SHORT).show()
        }

        stopBtn.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}