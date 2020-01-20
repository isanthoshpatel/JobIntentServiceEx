package com.example.jobintentserviceex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1.setOnClickListener {
            var i = Intent(this,JobIntentServiceEx::class.java)
            i.putExtra("input",et1.text.toString())

            JobIntentServiceEx.enqueueWork(this,i)
        }
    }
}
