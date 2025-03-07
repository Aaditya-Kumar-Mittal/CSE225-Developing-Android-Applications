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

class ClassDemoTwoAlarmManager1 : AppCompatActivity() {

    private lateinit var alarmManagerClass : AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_two_alarm_manager1)


        var startBtn = findViewById<Button>(R.id.alarmStartBtn1)
        var repeatBtn = findViewById<Button>(R.id.alarmRepeatBtn1)
        var cancelBtn = findViewById<Button>(R.id.alarmCancelBtn1)
        var getSecondCount = findViewById<EditText>(R.id.getSecondCount1)
        
        // Create the intent for alarm broadcast
        val intent = Intent(this, ClassDemoTwoAlarmManager1AlarmBroadcast1::class.java)

        // Create pending intent
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        startBtn.setOnClickListener {
            var i = getSecondCount.text.toString().toInt()
            alarmManagerClass = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManagerClass.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent)
            Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show()
        }

        repeatBtn.setOnClickListener {
            var i = getSecondCount.text.toString().toInt()
            alarmManagerClass = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManagerClass.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (i * 1000).toLong(), pendingIntent)
            Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show()
        }

        cancelBtn.setOnClickListener {
            alarmManagerClass = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManagerClass.cancel(pendingIntent)
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }

    }
}