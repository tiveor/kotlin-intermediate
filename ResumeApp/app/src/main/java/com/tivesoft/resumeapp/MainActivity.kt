package com.tivesoft.resumeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnWorkHistory = findViewById<Button>(R.id.btnWorkHistory)


        btnWorkHistory.setOnClickListener {

            var intent = Intent(applicationContext, WorkHistoryActivity::class.java)
            startActivity(intent)
        }

    }
}
