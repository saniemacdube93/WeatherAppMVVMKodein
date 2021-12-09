package za.co.krd.macweatherapper.data.enity2


import com.google.gson.annotations.SerializedName

data class Wind(
    val speed: Double,
    val deg: Int,
    val gust: Double
)