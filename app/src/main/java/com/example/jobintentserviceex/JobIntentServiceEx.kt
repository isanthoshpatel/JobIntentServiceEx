package com.example.jobintentserviceex

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.JobIntentService
import androidx.core.app.NotificationCompat

class JobIntentServiceEx : JobIntentService() {


    companion object {
        fun enqueueWork(c: Context, i: Intent) {
            enqueueWork(c, JobIntentServiceEx::class.java, 123, i)
        }
    }

    override fun onHandleWork(intent: Intent) {
        var input = intent.getStringExtra("input")

        for (i in 0..10) {
            var n1 = NotificationCompat.Builder(this, "ch1")
                .setContentTitle(input)
                .setContentText("Running....$i")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(PendingIntent.getActivity(this,0,Intent(this,MainActivity::class.java),0))
                .build()

            startForeground(1, n1)
            if (isStopped) return
            SystemClock.sleep(2000)
        }
        stopSelf()
    }


    override fun onStopCurrentWork(): Boolean {
        return super.onStopCurrentWork()
    }
}