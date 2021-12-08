package za.co.krd.macweatherapper.data.db.entity2


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class MyList(
        @Embedded
        val main: String,
        @SerializedName("dt_txt")
        val dtTxt: Float,
)