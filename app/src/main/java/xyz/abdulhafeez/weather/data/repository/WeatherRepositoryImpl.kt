package xyz.abdulhafeez.weather.data.repository

import xyz.abdulhafeez.weather.data.mappers.toWeatherInfo
import xyz.abdulhafeez.weather.data.remote.WeatherApi
import xyz.abdulhafeez.weather.domain.repository.WeatherRepository
import xyz.abdulhafeez.weather.domain.util.Resource
import xyz.abdulhafeez.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}