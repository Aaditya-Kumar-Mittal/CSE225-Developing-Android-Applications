package com.example.cse225_codes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class ClassDemoTwoAlarmManager1AlarmBroadcast1 : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        // Get Media Player Service
        var mediaPlayer = MediaPlayer.create(context, R.raw.alarmsound1)

        // Log to check if the service is called
        Log.d("AlarmManager", "AlarmManager Called")

        mediaPlayer.start()

        Toast.makeText(context, "AlarmManager Called", Toast.LENGTH_SHORT).show()
    }
}