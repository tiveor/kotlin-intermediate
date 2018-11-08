package com.tivesoft.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnGetForecast = findViewById<Button>(R.id.btn_getForecast)


        btnGetForecast.setOnClickListener {
            var moveIntent = Intent(this, ListActivity::class.java)
            var ediSearchTerm = findViewById<EditText>(R.id.edi_search_term)
            moveIntent.putExtra("searchTerm", ediSearchTerm.text.toString())
            startActivity(moveIntent)
        }
    }
}
