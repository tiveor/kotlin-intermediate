package com.tivesoft.resumeapp

import android.content.Intent
import android.net.Uri
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

        var btnCallMe = findViewById<Button>(R.id.btnCallMe)
        btnCallMe.setOnClickListener {
            var phoneUri = Uri.parse("tel:+59112345678")
            var intent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(intent)
        }

        var btnEmailMe = findViewById<Button>(R.id.btnEmailMe)
        btnEmailMe.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)

            val to = "test@gmail.com"
            val subject = "Test Email Subject"
            val message = "Test Message"

//            intent.setType("message/rfc822")
            intent.setType("plain/text")
            intent.putExtra(Intent.EXTRA_EMAIL, to)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(intent);
        }


    }
}
