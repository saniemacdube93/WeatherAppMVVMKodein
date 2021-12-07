package za.co.krd.macweatherapper.data.db.entity2


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


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