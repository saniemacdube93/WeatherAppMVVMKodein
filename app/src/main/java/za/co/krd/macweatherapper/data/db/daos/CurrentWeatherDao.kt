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
import za.co.krd.macweatherapper.data.enity2.FutureResponse

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(main: FutureResponse)
    @Query("select * from harare_current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>
    @Query("select * from harare_current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}