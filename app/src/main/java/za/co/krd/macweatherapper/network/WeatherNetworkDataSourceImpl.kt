package za.co.krd.macweatherapper.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import za.co.krd.macweatherapper.data.OpenWeatherService
import za.co.krd.macweatherapper.data.enity2.FutureResponse
import za.co.krd.macweatherapper.data.response.CurrentWeatherResponse
import za.co.krd.macweatherapper.exceptions.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val openWeatherService: OpenWeatherService
): WeatherNetworkDataSource{
    private val _downlaodedCurrentWeather = MutableLiveData<FutureResponse>()
    override val downloadedCurrentWeather: LiveData<FutureResponse>
        get() = _downlaodedCurrentWeather



    override suspend fun fetchCurrentWeather(city: String ,unit: String) {
    try{
        val fetchedCurrentWeather = openWeatherService.getCurrentWeather(city , "metric").await()
        _downlaodedCurrentWeather.postValue(fetchedCurrentWeather)

    }catch (e: NoConnectivityException){
        Log.e("Connectivity ","No Internet Connection." , e)

    }
    }
}