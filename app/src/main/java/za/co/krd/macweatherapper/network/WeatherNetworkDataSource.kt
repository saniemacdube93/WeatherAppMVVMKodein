package za.co.krd.macweatherapper.network

import androidx.lifecycle.LiveData
import za.co.krd.macweatherapper.data.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        city: String ,
        unit:String
    )
}