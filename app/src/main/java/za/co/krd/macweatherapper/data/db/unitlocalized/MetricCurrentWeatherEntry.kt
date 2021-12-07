package za.co.krd.macweatherapper.data.db.unitlocalized

import androidx.room.ColumnInfo
import za.co.krd.macweatherapper.data.db.entity2.MyList

data class MetricCurrentWeatherEntry(
        @ColumnInfo(name = "cnt")
        override val cnt: Int,
        @ColumnInfo(name = "id")
        override val id: Int,
        @ColumnInfo(name = "list")
        override val list:  List<MyList>


) : UnitSpecificCurrentWeatherEntry