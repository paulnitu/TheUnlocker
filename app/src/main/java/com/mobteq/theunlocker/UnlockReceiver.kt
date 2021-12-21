package com.mobteq.theunlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class UnlockReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            val activityIntent = Intent(context, LockScreenActivity::class.java)
                .apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
            context.startActivity(activityIntent)
            Log.d("UnlockReceiver", " screenOff")
        } else if (intent.action == Intent.ACTION_SCREEN_ON) {
            Log.d("UnlockReceiver", " screenOn")
        }
    }
}