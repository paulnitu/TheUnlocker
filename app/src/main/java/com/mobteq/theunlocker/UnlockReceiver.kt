package com.mobteq.theunlocker

import android.app.ActionBar
import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class UnlockReceiver : BroadcastReceiver() {


    private lateinit var tv: TextView

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            val kgm = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            tv = TextView(context)
                .apply {
                    setText("Test Lockscreen")
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    textSize = 62f
                    width = ActionBar.LayoutParams.MATCH_PARENT
                    height = ActionBar.LayoutParams.MATCH_PARENT
                    setOnClickListener {
                        kgm.exitKeyguardSecurely { }
                        isVisible = false
                    }
                }
            val wm = context.getSystemService(WindowManager::class.java)
            wm.addView(tv, getParams())
            Log.d("UnlockReceiver", " screenOff")
        } else if (intent.action == Intent.ACTION_SCREEN_ON) {
            Log.d("UnlockReceiver", " screenOn")
        }
    }

    fun getParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or
                WindowManager.LayoutParams.FLAG_DIM_BEHIND,

            PixelFormat.TRANSLUCENT
        )
    }
}