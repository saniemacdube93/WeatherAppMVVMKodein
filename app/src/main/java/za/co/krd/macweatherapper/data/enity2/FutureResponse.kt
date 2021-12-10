package za.co.krd.macweatherapper.data.enity2


import androidx.room.*
import com.bumptech.glide.load.model.ByteArrayLoader
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "harare_current_weather")
data class FutureResponse(
        @PrimaryKey(autoGenerate = false)
        var id: Int = CURRENT_WEATHER_ID,
        val cod: String,
        val message: Int,
        val cnt: Int,
        @TypeConverters(DataConverter::class)
        val list: List<MyList>,
   //  val list: List<MyList>,
        @Embedded
    val city: City
)


//we will use Moshi as our Data converter
class DataConverter {
    private val moshi = Moshi.Builder().build()
    private val listMyData : ParameterizedType = Types.newParameterizedType(List::class.java, MyList::class.java)
    private val jsonAdapter: JsonAdapter<List<MyList>> = moshi.adapter(listMyData)

    @TypeConverter
    fun listMyModelToJsonStr(listMyModel: List<MyList>?): String? {
        return jsonAdapter.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListMyModel(jsonStr: String?): List<MyList>? {
        return jsonStr?.let { jsonAdapter.fromJson(jsonStr) }
    }
}


