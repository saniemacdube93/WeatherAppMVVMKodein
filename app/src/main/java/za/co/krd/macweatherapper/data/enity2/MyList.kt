package za.co.krd.macweatherapper.data.enity2


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class MyList(
//    val dt: Int,
    @Embedded
    val main: Main,
//    //val weather: List<Weather>,
//    @Embedded
//    val clouds: Clouds,
//    @Embedded
//    val wind: Wind,
//    val visibility: Int,
//    val pop: Int,
//    @Embedded
//    val sys: Sys,
//    @SerializedName("dt_txt")
//    val dtTxt: String,
////    @Embedded
//    val rain: Rain
)