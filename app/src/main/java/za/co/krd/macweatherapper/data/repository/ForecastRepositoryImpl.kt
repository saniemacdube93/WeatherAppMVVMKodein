package za.co.krd.macweatherapper.data.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import za.co.krd.macweatherapper.data.db.daos.CurrentWeatherDao
import za.co.krd.macweatherapper.data.db.entity2.WeatherForecastResult
import za.co.krd.macweatherapper.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import za.co.krd.macweatherapper.data.response.FureWeatherResponse
import za.co.krd.macweatherapper.network.WeatherNetworkDataSource

class ForecastRepositoryImpl(
   private val currentWeatherDao: CurrentWeatherDao,
   private val weatherNetworkDataSource: WeatherNetworkDataSource
): ForecastRepository {


   init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever{ newCurrentWeather ->
            //persist the weather to the local database after getting it
            persistFetchedCurrentWeather(newCurrentWeather)
        }
   }


    override suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>{
    return withContext(Dispatchers.IO){
        initWeatherData()
        return@withContext if (metric) currentWeatherDao.getWeatherMetric()
        else currentWeatherDao.getWeatherImperial()
        }
    }

    //we want to store all the data we just fetched from the API
    private fun persistFetchedCurrentWeather(fetchedWeather: WeatherForecastResult){
        //we will use Dispatchers coroutines
        GlobalScope.launch(Dispatchers.IO) {
            //upsert method insers or updates the CurrentWeatherResponse
       currentWeatherDao.upsert(fetchedWeather)
        }
    }

    private suspend fun initWeatherData(){
        if (isFetchCurrentlyNeeded(ZonedDateTime.now().minusHours(1)))
            fetchCurrentWeather()
    }


    private suspend fun fetchCurrentWeather(){
        weatherNetworkDataSource.fetchCurrentWeather("harare" , "metric")
    }


    //this method is what we will use to check if we really need to fetch data
    private fun isFetchCurrentlyNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }


}