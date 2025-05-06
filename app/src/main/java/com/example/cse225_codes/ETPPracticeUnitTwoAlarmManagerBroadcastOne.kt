package com.example.cse225_codes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class ETPPracticeUnitTwoAlarmManagerBroadcastOne : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        var mediaPlayer = MediaPlayer.create(context, R.raw.message1)

        Log.d("ETP Alarm Broadcaster", "Alarm has been broadcast successfully")

        mediaPlayer.start()

        Toast.makeText(context, "Alarm has been broadcast successfully", Toast.LENGTH_SHORT).show()
    }
}