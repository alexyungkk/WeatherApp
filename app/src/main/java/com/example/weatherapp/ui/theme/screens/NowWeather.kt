package com.example.weatherapp.ui.theme.screens

import android.view.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.Weather

@Composable
fun NowWeather(innerPadding: PaddingValues) {
    val nowWeather = Weather(
        "22 Sept 2026",
        "Sunny",
        temperature = "18",
        feelLike = "12",
        wind = "SW 18 kph",
        resourceId = R.drawable.sunny
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.mrweather),
                contentScale = ContentScale.Crop
            )
    ) {
        Image(
            painter = painterResource(id= nowWeather.resourceId),
            contentDescription = nowWeather.temperature
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(text= "Temperature: " + nowWeather.temperature, color = Color.White)
        Text(text= "Feel like: " + nowWeather.feelLike, color = Color.White)
        Text(text= "Wind: " + nowWeather.wind, color = Color.White)
    }
}
