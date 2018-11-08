package com.tivesoft.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var lstForeCast = findViewById<ListView>(R.id.lst_forecast);

        var weathers = listOf("20C Sunny", "12C Raining", "15C Cool", "2C Cold", "1C Snow")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, weathers);
        lstForeCast.adapter = adapter;

    }
}
