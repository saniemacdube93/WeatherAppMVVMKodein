package za.co.krd.macweatherapper.data.enity2


import androidx.room.*
import com.bumptech.glide.load.model.ByteArrayLoader
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "harare_current_weather")
data class FutureResponse(
        @PrimaryKey(autoGenerate = false)
        var id: Int = CURRENT_WEATHER_ID,
        val cod: String,
        val message: Int,
        val cnt: Int,
        @TypeConverters(HobbiesTypeConveter::class)
        val list: List<MyList>,
   //  val list: List<MyList>,
        @Embedded
    val city: City
)


class HobbiesTypeConveter {
    @TypeConverter
    fun toString(barcodeList: List<MyList>?): String? {
        if (barcodeList == null) return null

        val stringList = mutableListOf<String>()
        barcodeList.forEach {
            stringList.add(it.dtTxt)

        }

        return stringList.joinToString(",")
    }

    @TypeConverter
    fun toBarcodeList(str: String?): List<MyList>? {
        if (str == null) return null

        val barcodeList = mutableListOf<MyList>()

        val strList = str.split(",")
        for (i in strList.indices step 2) {
            barcodeList.add(MyList(strList[i]))
        }

        return barcodeList
    }
}
