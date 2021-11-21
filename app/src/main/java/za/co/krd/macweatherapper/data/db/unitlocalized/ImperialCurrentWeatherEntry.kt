package za.co.krd.macweatherapper.data.db.unitlocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntry(
   @ColumnInfo(name = "temp")
    override val temp: Double,
   @ColumnInfo(name = "feelsLike")
   override val feelsLike: Double,
   @ColumnInfo(name = "tempMin")
   override val tempMin: Double,
   @ColumnInfo(name = "tempMax")
   override val tempMax: Double,
   @ColumnInfo(name = "pressure")
   override val pressure: Int,
   @ColumnInfo(name = "humidity")
   override val humidity: Int,
   @ColumnInfo(name = "seaLevel")
   override val seaLevel: Int,
   @ColumnInfo(name = "grndLevel")
   override val grndLevel: Int

) : UnitSpecificCurrentWeatherEntry