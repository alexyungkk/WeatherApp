package com.example.weatherapp.ui.theme.screens


import android.net.wifi.p2p.WifiP2pManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.Weather

@Composable
fun DailyWeather(innerPadding: PaddingValues){


    val listDailyWeather = listOf(
        Weather(
            "23 Sept 2026",
            "Overcast",
            temperature = "10",
            feelLike = "4",
            wind = "20 kmph",
            resourceId = R.drawable.overcast
        ),
        Weather(
            "24 Sept 2026",
            "Cloudy",
            "9",
            "9",
            "0 kmph",
            R.drawable.cloudy
        ),
        Weather(
            "25 Sept 2026",
            "Rain",
            "9",
            "9",
            "0 kmph",
            R.drawable.rain
        )
    )
    LazyColumn(
        modifier = Modifier
            .background(color = Color.LightGray)
            .paint(
                painter = painterResource(id = R.drawable.observatory),
                contentScale = ContentScale.Crop
            )
    ) {
        items(listDailyWeather) { weather ->
            Row() {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(weather.date, color = Color.White)
                    Image(
                        painter = painterResource(id = weather.resourceId),
                        contentDescription = weather.weather,
                        modifier = Modifier.size(120.dp)
                        )
                    Text("Weather: " + weather.weather + "\n"
                        + "Temperature: " + weather.temperature,
                        color = Color.White
                        )
                    Text("Feel like: " + weather.feelLike, color = Color.White)
                    Text("Wind: " + weather.wind, color = Color.White)
                }
            }
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
    }
}