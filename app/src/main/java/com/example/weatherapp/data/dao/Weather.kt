package com.example.weatherapp.data.dao

import com.google.gson.annotations.SerializedName

data class Weather (
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val region:String
)

data class Current(
    val condition: Condition,
//    @SerializedName("icon") val weatherIcon: String,
    @SerializedName("temp_c") val tempCelsius: Float,
    @SerializedName("feelslike_c") val feelslike_c: Float,
    @SerializedName("wind_kph") val wind_kph: Float,
    @SerializedName("wind_dir") val wind_dir: String,
    @SerializedName("chance_of_rain") val chance_of_rain: Float,
    @SerializedName("precip_mm") val precip_mm: Float,
    @SerializedName("humidity") val humidity: Float,
)
//
data class Condition(
    @SerializedName("text") val description: String,
    @SerializedName("icon") val weatherIcon: String,
)

data class Forecast(
    @SerializedName ("forecastday")val forecastDays: List<ForecastDay>
)

data class ForecastDay (
    val date: String,
    val day: Day
)

data class Day (
    val condition: Condition,
    @SerializedName ("maxtemp_c") val maxTempCelsius: Float,
    @SerializedName ("mintemp_c") val minTempCelsius: Float,
    @SerializedName ("maxwind_kph") val maxwind_kph: Float,
    @SerializedName ("daily_chance_of_rain") val daily_chance_of_rain: Float,
    @SerializedName ("totalprecip_mm") val totalprecip_mm: Float,
    @SerializedName ("avghumidity") val avghumidity: Float,
)

