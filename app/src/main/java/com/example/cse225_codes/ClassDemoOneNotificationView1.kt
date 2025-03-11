package com.example.cse225_codes

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ClassDemoOneNotificationView1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_notification_view1)

        val textView = findViewById<TextView>(R.id.notificationTextview1)

        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val replyText = remoteInput.getCharSequence("Remote_Key")?.toString()
            textView.text = replyText ?: "No reply received"
        }

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(1234) // Dismiss the notification
    }
}
