package com.example.cse225_codes

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.ContentResolver
import android.content.Intent
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class ETPPracticeUnitTwoNotificationManagerOne : AppCompatActivity() {

    // Important Components Required for Notification
    private lateinit var etpNotificationManager1: NotificationManager
    private lateinit var etpNotificationChannel1: NotificationChannel
    private lateinit var etpNotificationBuilder1: Notification.Builder
    private lateinit var etpNotificationPendingIntent1: PendingIntent
    private lateinit var etpNotificationSoundUri: Uri
    private lateinit var etpNotificationAudioAttributes1: AudioAttributes
    private lateinit var etpNotificationRemoteInput1: RemoteInput

    // Notification Constants
    private val etpNotificationChannelId = "My_Channel_ID1"
    private val etpNotificationDescription = "ETP Test Notification 2"
    private val etpNotificationTitle = "ETP Notification Manager Example"
    private val etpNotificationMyKey = "ETP_Remote_Key"
    private val etpNotificationID = 123456

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_two_notification_manager_one)

        val etpNotificationButton = findViewById<Button>(R.id.etpNotificationBtn1)
        etpNotificationManager1 = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        etpNotificationButton.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, ETPPracticeUnitTwoNotificationManagerViewOne::class.java)
        etpNotificationPendingIntent1 = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)
        etpNotificationSoundUri = (ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + applicationContext.packageName + "/" + R.raw.message1).toUri()
        etpNotificationAudioAttributes1 = AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).setUsage(AudioAttributes.USAGE_NOTIFICATION).build()

        createNotificationChannel()

        etpNotificationRemoteInput1 = RemoteInput.Builder(etpNotificationMyKey).setLabel("ETP Notification").build()
        val etpNotificationAction =
            Notification.Action.Builder(R.drawable.baseline_check_circle_outline_24, "ETP Reply", etpNotificationPendingIntent1).addRemoteInput(etpNotificationRemoteInput1).build()
        etpNotificationBuilder1.addAction(etpNotificationAction)
        etpNotificationManager1.notify(etpNotificationID, etpNotificationBuilder1.build())

    }

    public fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            etpNotificationChannel1 = NotificationChannel(
                etpNotificationChannelId,
                etpNotificationDescription,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                enableLights(true)
                enableVibration(true)
                setSound(etpNotificationSoundUri, etpNotificationAudioAttributes1)
            }
            etpNotificationManager1.createNotificationChannel(etpNotificationChannel1)
            etpNotificationBuilder1 = Notification.Builder(this, etpNotificationChannelId)
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentTitle(etpNotificationTitle)
                .setContentText(etpNotificationDescription)
                .setContentIntent(etpNotificationPendingIntent1)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
        } else {
            etpNotificationBuilder1 = Notification.Builder(this, etpNotificationChannelId)
                .setSmallIcon(R.drawable.baseline_notifications_24)
                .setContentTitle(etpNotificationTitle)
                .setContentText(etpNotificationDescription)
                .setContentIntent(etpNotificationPendingIntent1)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
        }

    }
}