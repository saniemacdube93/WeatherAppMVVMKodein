package za.co.krd.macweatherapper.data.db.unitlocalized

import androidx.room.ColumnInfo
import za.co.krd.macweatherapper.data.enity2.MyList

data class ImperialCurrentWeatherEntry(
        @ColumnInfo(name = "cod")
        override val cod: Double,
        @ColumnInfo(name = "list")
        override val list: List<MyList>

//        @ColumnInfo(name = "message")
//        override val message: Int,
//        @ColumnInfo(name = "message")
//        override val cnt: Int


   ) : UnitSpecificCurrentWeatherEntry