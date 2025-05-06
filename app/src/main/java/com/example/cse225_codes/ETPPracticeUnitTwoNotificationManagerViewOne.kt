package com.example.cse225_codes

import android.app.NotificationManager
import android.app.RemoteInput
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETPPracticeUnitTwoNotificationManagerViewOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_two_notification_manager_view_one)

        val etpNotificationTextView = findViewById<TextView>(R.id.etpNotificationTextview1)
        
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val replyText = remoteInput.getCharSequence("ETP_Remote_Key")?.toString()
            etpNotificationTextView.text = replyText ?: "No reply received"
        }

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(123456) // Dismiss the notification

    }
}