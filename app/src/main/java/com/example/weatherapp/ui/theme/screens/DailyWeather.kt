package com.example.weatherapp.ui.theme.screens

import android.graphics.fonts.Font
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.MainViewModel
import kotlin.math.roundToInt
import coil3.compose.AsyncImage


@Composable
fun DailyWeather(viewModel: MainViewModel){
    val weather = viewModel.weather
    weather?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(weather.forecast.forecastDays) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("${item.date}", fontWeight = FontWeight.Bold)
                        AsyncImage(
                            model = "https://${item.day.condition.weatherIcon}",
                            contentDescription = "Weather Icon",
                            modifier = Modifier.size(100.dp)
                        )
                        Text("${item.day.condition.description}")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1.2f)
                    ) {
                        Text("Max: ${item.day.maxTempCelsius.roundToInt()} °C")
                        Text("Min: ${item.day.minTempCelsius.roundToInt()} °C")
                        Text("Max Wind Speed: ${item.day.maxwind_kph.roundToInt()} kph")
                        Text("Chance of Rain: ${item.day.daily_chance_of_rain.roundToInt()} %")
                        Text("Precipitation: ${item.day.totalprecip_mm.roundToInt()} mm")
                        Text("Humidity: ${item.day.avghumidity.roundToInt()} %")
                    }
                }
            }
        }
    }
}