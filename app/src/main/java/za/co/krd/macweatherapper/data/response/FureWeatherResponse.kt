package za.co.krd.macweatherapper.data.response


import com.google.gson.annotations.SerializedName
import za.co.krd.macweatherapper.data.db.entity2.WeatherForecastResult

data class FureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: WeatherForecastResult,

    )