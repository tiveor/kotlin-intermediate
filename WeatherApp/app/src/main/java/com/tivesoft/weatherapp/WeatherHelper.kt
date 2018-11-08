package com.tivesoft.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface WeatherService {
    @GET("bins/vz4p2")
    fun getForecast(): Call<List<Forecast>>
}


class Forecast(val high: String, val low: String)

class WeatherRetriever {
    val service: WeatherService

    init {
        val retrofit = Retrofit.Builder().baseUrl("http://api.myjson.com/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherService::class.java)
    }

    fun getForecast(callback: Callback<List<Forecast>>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }
}


