package za.co.krd.macweatherapper.ui.weather.Current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import za.co.krd.macweatherapper.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory (
    private val forecastRepository: ForecastRepository
    ): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository) as T
    }
}

