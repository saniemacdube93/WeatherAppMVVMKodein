package za.co.krd.macweatherapper.data.db.entity2


import com.google.gson.annotations.SerializedName

data class MyList(
    val main: Main,
    @SerializedName("dt_txt")
    val dtTxt: String,
)