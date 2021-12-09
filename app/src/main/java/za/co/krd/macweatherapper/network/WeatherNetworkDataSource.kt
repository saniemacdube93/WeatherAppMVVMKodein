package za.co.krd.macweatherapper.network

import androidx.lifecycle.LiveData
import za.co.krd.macweatherapper.data.enity2.FutureResponse
import za.co.krd.macweatherapper.data.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<FutureResponse>

    suspend fun fetchCurrentWeather(
        city: String ,
        unit:String
    )
}