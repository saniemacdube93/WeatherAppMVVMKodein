package za.co.krd.macweatherapper.data.repository

import androidx.lifecycle.LiveData
import za.co.krd.macweatherapper.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}