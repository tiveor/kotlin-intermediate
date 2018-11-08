package com.tivesoft.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface WeatherService {
    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"Cochabamba\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast(): Call<Weather>
}


class Weather(val query: WeatherQuery)
class WeatherQuery(val results: WeatherResult)
class WeatherResult(val channel: WeatherChannel)
class WeatherChannel(val title: String, val item: WeatherItem)
class WeatherItem(val forecast: List<Forecast>)
class Forecast(val date: String, val day: String, val high: String, val low: String, val text: String)

class WeatherRetriever {
    val service: WeatherService

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://query.yahooapis.com/v1/public/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherService::class.java)
    }

    fun getForecast(callback: Callback<Weather>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }
}

