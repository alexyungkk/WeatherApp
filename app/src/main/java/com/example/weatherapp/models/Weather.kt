package com.example.weatherapp.models

data class Weather(
    val date: String,
    val weather: String,
    val temperature: String,
    val feelLike: String,
    val wind: String,
    val resourceId: Int
)