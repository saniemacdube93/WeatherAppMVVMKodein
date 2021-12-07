package za.co.krd.macweatherapper.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import za.co.krd.macweatherapper.data.OpenWeatherService
import za.co.krd.macweatherapper.data.db.entity2.WeatherForecastResult
import za.co.krd.macweatherapper.data.response.FureWeatherResponse
import za.co.krd.macweatherapper.exceptions.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val openWeatherService: OpenWeatherService
): WeatherNetworkDataSource{
    private val _downlaodedCurrentWeather = MutableLiveData<WeatherForecastResult>()
    override val downloadedCurrentWeather: LiveData<WeatherForecastResult>
        get() = _downlaodedCurrentWeather



    override suspend fun fetchCurrentWeather(city: String ,unit: String) {
    try{
        val fetchedCurrentWeather = openWeatherService.getCurrentWeather(city).await()
        _downlaodedCurrentWeather.postValue(fetchedCurrentWeather)
        Log.e("Fetched ","The Data has been succesfully fetched.")


    }catch (e: NoConnectivityException){
        Log.e("Connectivity ","No Internet Connection." , e)

    }
    }
}