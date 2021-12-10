package za.co.krd.macweatherapper.ui.weather.Current

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_future_weather.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle
import za.co.krd.macweatherapper.R
import za.co.krd.macweatherapper.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

class FutureWeatherItem(
    val weatherEntry: UnitSpecificCurrentWeatherEntry
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textView_condition.text = "Mac"
            updateDate()
            updateTemperature()
        }
    }

    override fun getLayout() = R.layout.item_future_weather

    private fun ViewHolder.updateDate() {
        val dtFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        textView_date.text = "Busto"
    }

    private fun ViewHolder.updateTemperature() {
        val unitAbbreviation = if (weatherEntry is UnitSpecificCurrentWeatherEntry) "°C"
        else "°F"
        textView_temperature.text = "${weatherEntry.list.get(0).main.temp}$unitAbbreviation"
    }


}