package za.co.krd.macweatherapper.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import za.co.krd.macweatherapper.data.OpenWeatherService
import za.co.krd.macweatherapper.data.response.CurrentWeatherResponse
import za.co.krd.macweatherapper.exceptions.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val openWeatherService: OpenWeatherService
): WeatherNetworkDataSource{
    private val _downlaodedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downlaodedCurrentWeather

    override suspend fun fetchCurrentWeather(city: String) {
    try{
        val fetchedCurrentWeather = openWeatherService.getCurrentWeather(city).await()
        _downlaodedCurrentWeather.postValue(fetchedCurrentWeather)

    }catch (e: NoConnectivityException){
        Log.e("Connectivity ","No Internet Connection." , e)

    }
    }
}