package com.example.cse225_codes

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.ContentResolver
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.net.toUri

class ClassDemoOneNotificationManager1 : AppCompatActivity() {

    // Notification components
    private lateinit var notificationManager1: NotificationManager
    private lateinit var notificationChannel1: NotificationChannel
    private lateinit var notificationBuilder1: Notification.Builder
    private lateinit var pendingIntent1: PendingIntent
    private lateinit var soundUri: Uri
    private lateinit var audioAttributes: AudioAttributes
    private lateinit var remoteInput1: RemoteInput

    // Constants
    private val channelId = "My_Channel_ID"
    private val description = "Test Notification 1"
    private val title = "Notification Manager Example"
    private val myKey = "Remote_Key"
    private val notificationId = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_notification_manager1)

        // Get the button from the layout
        val notifyBtn = findViewById<CardView>(R.id.showNotification1)

        // Get the notification manager service
        notificationManager1 = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notifyBtn.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, ClassDemoOneNotificationView1::class.java)
        pendingIntent1 = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )

        soundUri = (ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + applicationContext.packageName + "/" + R.raw.message1).toUri()

        audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()

        createNotificationChannel()

        remoteInput1 = RemoteInput.Builder(myKey).setLabel("Replying...").build()

        val action = Notification.Action.Builder(
            R.drawable.baseline_check_circle_outline_24, "Reply", pendingIntent1
        ).addRemoteInput(remoteInput1).build()

        notificationBuilder1.addAction(action)
        notificationManager1.notify(notificationId, notificationBuilder1.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel1 = NotificationChannel(
                channelId, description, NotificationManager.IMPORTANCE_HIGH
            ).apply {
                enableLights(true)
                enableVibration(true)
                lightColor = Color.GREEN
                setSound(soundUri, audioAttributes)
            }

            notificationManager1.createNotificationChannel(notificationChannel1)

            notificationBuilder1 = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.img_13))
                .setContentIntent(pendingIntent1)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setOngoing(false)
        } else {
            notificationBuilder1 = Notification.Builder(this)
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent1)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setOngoing(false)
        }
    }
}
