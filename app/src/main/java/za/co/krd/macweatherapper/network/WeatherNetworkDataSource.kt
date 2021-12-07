package za.co.krd.macweatherapper.network

import androidx.lifecycle.LiveData
import za.co.krd.macweatherapper.data.db.entity2.WeatherForecastResult



interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<WeatherForecastResult>

    suspend fun fetchCurrentWeather(
        city: String ,
        unit:String
    )
}