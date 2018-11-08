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


        var retriever = WeatherRetriever()

        val callback = object : Callback<Weather> {

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                println("We got a response")
                println(response?.body())

                title = response?.body()?.query?.results?.channel?.title

                var forecasts = response?.body()?.query?.results?.channel?.item?.forecast
                var forecastStrings = mutableListOf<String>()

                if (forecasts != null) {
                    for (forecast in forecasts) {
                        forecastStrings.add("${forecast.date} - High: ${forecast.high} Low: ${forecast.low} - ${forecast.text}")
                    }
                }

                var lstForeCast = findViewById<ListView>(R.id.lst_forecast)

                var adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, forecastStrings)
                lstForeCast.adapter = adapter
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                println("It Failed")
                println(t.message)
            }

        }

        val searchTerm = intent.extras.getString("searchTerm")

        retriever.getForecast(searchTerm, callback)
    }
}
