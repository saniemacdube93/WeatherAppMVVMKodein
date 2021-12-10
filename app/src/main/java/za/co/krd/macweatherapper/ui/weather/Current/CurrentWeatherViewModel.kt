package za.co.krd.macweatherapper.ui.weather.Current

import androidx.lifecycle.ViewModel
import za.co.krd.macweatherapper.data.UnitSystem
import za.co.krd.macweatherapper.data.lazyDeferred
import za.co.krd.macweatherapper.data.repository.ForecastRepository

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
): ViewModel() {

    private val unitSystem =  UnitSystem.METRIC//get from settings later

    val isMetric:Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weatherMac by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}