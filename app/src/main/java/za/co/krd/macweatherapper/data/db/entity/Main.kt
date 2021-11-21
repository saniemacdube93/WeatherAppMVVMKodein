package za.co.krd.macweatherapper.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


const val CURRENT_WEATHER_ID = 0

//this is the name of the db we are going to be using
//hence we make this class an entity with table name known as current weather
//there is no need for us to use @Embeded as all these are Primitives
@Entity(tableName = "harare_current_weather")
data class Main(
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("grnd_level")
    val grndLevel: Int
)
{
    //we are creating a new our own primary key which is not from the entity related to the response
    //Our primary key is constant as we will only store the latest reading in the database that is the reason we set autoGenerate to false
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}