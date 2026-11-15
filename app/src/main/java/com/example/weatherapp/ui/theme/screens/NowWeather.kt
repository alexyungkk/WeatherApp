package com.example.weatherapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import kotlin.math.roundToInt
import com.example.weatherapp.MainViewModel
@Composable
fun NowWeather(viewModel: MainViewModel) {
    val weather = viewModel.weather
    val searchTextFieldState = rememberTextFieldState(initialText = "")

    val location = viewModel.location
    val coordinates = "${location?.latitude},${location?.longitude}"
    LaunchedEffect(key1 = location) {
        if (location != null) {
            viewModel.getWeather(query = coordinates)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            state = searchTextFieldState,
            label = { Text("Search the Location") }
        )
        Button(
            onClick = {
                if (searchTextFieldState.text.toString().trim().isEmpty()) {
                    viewModel.getWeather(query = coordinates)
                } else {
                    viewModel.getWeather(searchTextFieldState.text.toString().trim())
                }
                searchTextFieldState.clearText()
            }
        ) {
            Text("Search")
        }
    }

    weather?.let {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = "https://${weather.current.condition.weatherIcon}",
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(100.dp)
                )
                Text("${weather.current.condition.description}")
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text("${weather.current.tempCelsius.roundToInt()}°C", style = MaterialTheme.typography.headlineLarge)
                Text("Feel like: ${weather.current.feelslike_c.roundToInt()}°C")
                Text("Wind: ${weather.current.wind_kph.roundToInt()}km/h")
                Text("Wind Direction: ${weather.current.wind_dir}")
                Text("Chance of Rain: ${weather.current.chance_of_rain} %")
                Text("Precipitation: ${weather.current.precip_mm} mm")
                Text("Humidity: ${weather.current.humidity} %")
            }
        }
    }
}

