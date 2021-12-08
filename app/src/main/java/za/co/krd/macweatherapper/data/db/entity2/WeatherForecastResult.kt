package za.co.krd.macweatherapper.data.db.entity2


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "harare_current_weather")
public data class WeatherForecastResult(
    val cnt: Int,
    val list: List<MyList>,
)
{
    //we are creating a new our own primary key which is not from the entity related to the response
    //Our primary key is constant as we will only store the latest reading in the database that is the reason we set autoGenerate to false
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}

object BarcodeListConverter {
    @TypeConverter
    fun toString(barcodeList: List<MyList>?): String? {
        if (barcodeList == null) return null

        val stringList = mutableListOf<String>()
        barcodeList.forEach {
            stringList.add(it.main.toString())

        }

        return stringList.joinToString(",")
    }

    @TypeConverter
    fun toBarcodeList(str: String?): List<MyList>? {
        if (str == null) return null

        val barcodeList = mutableListOf<MyList>()

        val strList = str.split(",")
        for (i in strList.indices step 2) {
            barcodeList.add(MyList(strList[i], strList[i + 1].toFloat()))
        }

        return barcodeList
    }
}



//class MyListTypeConveter {
//    @TypeConverter
//    fun listToJson(value: List<MyList>?) = Gson().toJson(value)
//
//    fun jsonToList(value: String) = Gson().fromJson(value , Array<MyList>::class.java).toList()
//    }
//
//








//
//class MacTypeConveter {
//    @TypeConverter
//    fun listToJson(value: List<MyList>) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToList(value: String) = Gson().fromJson(value , Array<MyList>::class.java).toString()
//}





