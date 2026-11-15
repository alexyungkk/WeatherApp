package com.example.weatherapp

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.data.dao.Weather
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(app)
    var location by mutableStateOf<Location?>(null) // NOTE: import Android's built-in Location class  android.location.Location
        private set
    @SuppressLint("MissingPermission") // silence warning
    fun refreshLocation() {
        fusedLocationClient
            .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { result ->
                location = result
                val latlng = "lat: ${location?.latitude}, lng: ${location?.longitude}"
                Log.i("MainViewModel", "Phone is location at $latlng.")
            }
    }



    var weather by mutableStateOf<Weather?>(null)
        private set
    var error by mutableStateOf<String?>(null)
        private set

//    init {
//        getWeather("Halifax")
//    }

    private val api = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/") // API hostname
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    fun getWeather(query: String) {
        viewModelScope.launch {
            try {
                weather = null
                // Call your API inside a coroutine function
                val response = api.searchLocation(
                    apiKey = BuildConfig.API_KEY,
                    location = query
                )
                weather = response
                error = null
            } catch (e: Exception) {
                // Handle any network errors here
                Log.e("MainViewModel",e.toString())
                error = "The location was not found. Try again!"
            }
        }
    }

//    val weather: Any
}