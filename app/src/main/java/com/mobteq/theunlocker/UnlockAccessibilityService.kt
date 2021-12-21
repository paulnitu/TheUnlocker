package com.mobteq.theunlocker

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent

class UnlockAccessibilityService : AccessibilityService() {

    lateinit var unlockReceiver: UnlockReceiver

    override fun onServiceConnected() {
        super.onServiceConnected()
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
        }
        unlockReceiver = UnlockReceiver()
        registerReceiver(unlockReceiver, filter)
        Log.d("UnlockReceiver", " starting")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d("Unlock", " accessibility event ")
    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        Log.d("Unlock", " accessibility key event ")
        return super.onKeyEvent(event)
    }

    override fun onInterrupt() {
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(unlockReceiver)
    }
}