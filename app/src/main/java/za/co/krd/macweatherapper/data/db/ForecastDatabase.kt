package za.co.krd.macweatherapper.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import za.co.krd.macweatherapper.data.db.daos.CurrentWeatherDao
import za.co.krd.macweatherapper.data.db.entity.Main
import za.co.krd.macweatherapper.data.enity2.DataConverter
import za.co.krd.macweatherapper.data.enity2.FutureResponse

@Database(
    entities = [FutureResponse::class],
    version = 1
)
@TypeConverters(DataConverter::class)
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