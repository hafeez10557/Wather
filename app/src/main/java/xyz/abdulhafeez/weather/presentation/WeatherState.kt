package xyz.abdulhafeez.weather.presentation

import xyz.abdulhafeez.weather.domain.weather.WeatherInfo


data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)