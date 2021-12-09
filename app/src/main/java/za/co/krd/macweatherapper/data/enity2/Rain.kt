package za.co.krd.macweatherapper.data.enity2


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    val h: Double
)