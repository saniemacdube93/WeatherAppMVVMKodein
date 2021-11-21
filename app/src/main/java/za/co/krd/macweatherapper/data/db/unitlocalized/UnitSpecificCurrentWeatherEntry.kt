package za.co.krd.macweatherapper.data.db.unitlocalized

import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeatherEntry {
    val temp: Double
    val feelsLike: Double
    val tempMin: Double
    val tempMax: Double
    val pressure: Int
    val humidity: Int
    val seaLevel: Int
    val grndLevel: Int
}