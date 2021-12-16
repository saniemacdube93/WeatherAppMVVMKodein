package za.co.krd.macweatherapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import za.co.krd.macweatherapper.ui.weather.Future.Detail.FutureDetailsFragment
import za.co.krd.macweatherapper.ui.weather.Future.List.FureListWeather

class Dispatcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispatcher)
        val fragmentList  = FureListWeather()
        supportFragmentManager.beginTransaction().replace(R.id.frame_container , fragmentList).commit()
    }
    fun weatherDetails(temperature: String) {
        val bundle = Bundle()
        bundle.putString("temperature", temperature)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentDetails = FutureDetailsFragment()
        fragmentDetails.arguments = bundle
        transaction.replace(R.id.frame_container , fragmentDetails)
        transaction.commit()
    }
}