package za.co.krd.macweatherapper.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import za.co.krd.macweatherapper.data.db.daos.CurrentWeatherDao
import za.co.krd.macweatherapper.data.db.entity2.BarcodeListConverter
import za.co.krd.macweatherapper.data.db.entity2.WeatherForecastResult

@Database(
    entities = [WeatherForecastResult::class], version = 1)
@TypeConverters(BarcodeListConverter::class)
abstract class ForecastDatabase : RoomDatabase(){
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object{
       @Volatile private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ForecastDatabase::class.java , "harare.db" )
                .build()

    }

}