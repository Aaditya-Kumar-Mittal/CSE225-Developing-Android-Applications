package com.example.cse225_codes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class CA1PracticeUnit2AlarmManger1Broadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        // Get the media player object
        val mediaPlayer = MediaPlayer.create(context, R.raw.alert1)
        Log.d("Alarm Manager", "Alarm Broadcast")
        mediaPlayer.start()
        Toast.makeText(context, "Alarm Broadcast", Toast.LENGTH_SHORT).show()
    }
}