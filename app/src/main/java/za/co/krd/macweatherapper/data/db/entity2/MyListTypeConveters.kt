//package za.co.krd.macweatherapper.data.db.entity2
//
//import androidx.room.TypeConverter
//import com.google.gson.Gson
//
//class MyListTypeConveters {
//    @TypeConverter
//    fun listToJson(value: List<MyList>?) = Gson().toJson(value)
//
//    fun jsonToList(value: String) = Gson().fromJson(value , Array<MyList>::class.java).toList()
//}