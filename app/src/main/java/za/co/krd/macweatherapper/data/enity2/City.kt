package za.co.krd.macweatherapper.data.enity2


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class City(
    val name: String,
    @Embedded
    val coord: Coord,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)