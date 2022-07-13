package xyz.abdulhafeez.weather.domain.repository

import xyz.abdulhafeez.weather.domain.util.Resource
import xyz.abdulhafeez.weather.domain.weather.WeatherInfo


interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}