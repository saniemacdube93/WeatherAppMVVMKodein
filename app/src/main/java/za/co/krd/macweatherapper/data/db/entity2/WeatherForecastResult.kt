package za.co.krd.macweatherapper.data.db.entity2


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken


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

class MacTypeConveter {
    @TypeConverter
    fun listToJson(value: List<MyList>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value , Array<MyList>::class.java).toString()
    }






