package za.co.krd.macweatherapper.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import za.co.krd.macweatherapper.data.db.daos.CurrentWeatherDao
import za.co.krd.macweatherapper.data.db.entity.Main

@Database(
    entities = [Main::class],
    version = 1
)
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