package za.co.krd.macweatherapper.data.db.unitlocalized

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import za.co.krd.macweatherapper.data.enity2.MyList

interface UnitSpecificCurrentWeatherEntry {
    val cod: Double
    val list: List<MyList>

//    val message: Int
//    val cnt: Int
}