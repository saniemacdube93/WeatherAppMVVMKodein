package za.co.krd.macweatherapper.data.db.unitlocalized

import com.google.gson.annotations.SerializedName
import za.co.krd.macweatherapper.data.db.entity2.MyList

interface UnitSpecificCurrentWeatherEntry {
    val cnt: Int
    val id: Int
    val list:  String


}