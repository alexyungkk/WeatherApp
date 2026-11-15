package com.example.weatherapp.data

import com.example.weatherapp.data.dao.Weather
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {

//https://api.weatherapi.com/v1/
    // forecast.json
    // ?key=
    // &q=Halifax%2c+Canada
    // &days=3
    // &aqi=no&alerts=no
    @GET("forecast.json")
    suspend fun searchLocation(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 3,
    ): Weather
}