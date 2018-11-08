package com.tivesoft.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var lstForeCast = findViewById<ListView>(R.id.lst_forecast);

        var weathers = listOf("20C Sunny", "12C Raining", "15C Cool", "2C Cold", "1C Snow")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, weathers);
        lstForeCast.adapter = adapter;


        var retriever = WeatherRetriever()

        val callback = object : Callback<List<Forecast>> {

            override fun onResponse(call: Call<List<Forecast>>, response: Response<List<Forecast>>) {
                println("We got a response")
                println(response?.body())

                for (forecast in response!!.body()!!) {
                    println("High:${forecast.high} Low:${forecast.low}")
                }
            }

            override fun onFailure(call: Call<List<Forecast>>, t: Throwable) {
                println("It Failed")
                println(t.message)
            }

        }

        retriever.getForecast(callback)
    }
}
