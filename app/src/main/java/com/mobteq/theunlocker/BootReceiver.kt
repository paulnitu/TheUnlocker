package com.mobteq.theunlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            context.startService(Intent(context, UnlockService::class.java))
            Log.d("BootReceiver", "Starting UnlockService")
        }
    }
}
