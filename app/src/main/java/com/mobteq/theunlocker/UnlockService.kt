package com.mobteq.theunlocker

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.service.notification.NotificationListenerService
import android.util.Log

class UnlockService : NotificationListenerService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d("UnlockService", " started")

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
        }

        registerReceiver(UnlockReceiver(), filter)
        return Service.START_STICKY
    }

}