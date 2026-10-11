package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pokemonsandbox.ui.theme.Navigation
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.screens.DailyWeather
import com.example.weatherapp.ui.theme.screens.NowWeather

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //test commit
            WeatherAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//                    NowWeather(innerPadding)
//                    DailyWeather(innerPadding)
                Navigation()
            }
        }
    }
}