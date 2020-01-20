package com.example.jobintentserviceex

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.JobIntentService
import androidx.core.app.NotificationCompat

class JobIntentServiceEx : JobIntentService() {


    companion object {
        fun enqueueWork(c:Context,i:Intent){
            enqueueWork(c,JobIntentServiceEx::class.java,123,i)
        }
    }

    override fun onHandleWork(intent: Intent) {
        var input = intent.getStringExtra("input")

        var n1 = NotificationCompat.Builder(this,"ch1")
            .setContentTitle(input)
            .setContentText("Running....")
            .build()
        startForeground(1,n1)

        if (isStopped) return
        SystemClock.sleep(8000)
    }


    override fun onStopCurrentWork(): Boolean {
        return super.onStopCurrentWork()
    }
}