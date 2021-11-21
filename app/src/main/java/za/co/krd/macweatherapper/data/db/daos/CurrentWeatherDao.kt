package za.co.krd.macweatherapper.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import za.co.krd.macweatherapper.data.db.entity.CURRENT_WEATHER_ID
import za.co.krd.macweatherapper.data.db.entity.Main
import za.co.krd.macweatherapper.data.db.unitlocalized.ImperialCurrentWeatherEntry
import za.co.krd.macweatherapper.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    //upsert basically means update or insert basically at the same time
    //remember for the tables to be created or updated we have to pass the entity inside the upsert method
    //our strategy is replace just incase the entry exists we insert it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(main: Main)

    //retains live data from the server
    //the below is an sqllite query
    @Query("select * from harare_current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>


    @Query("select * from harare_current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}