package za.co.krd.macweatherapper.ui.weather.Current

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import za.co.krd.macweatherapper.R
import za.co.krd.macweatherapper.data.OpenWeatherService
import za.co.krd.macweatherapper.network.ConnectivityInterceptor
import za.co.krd.macweatherapper.network.ConnectivityInterceptorImpl
import za.co.krd.macweatherapper.network.WeatherNetworkDataSource
import za.co.krd.macweatherapper.network.WeatherNetworkDataSourceImpl
import za.co.krd.macweatherapper.ui.base.ScopedFragment

class CurrentWeatherFragment : ScopedFragment() , KodeinAware{
    //we are using Kodein for our dependency injection
    override val kodein by closestKodein()
   private val viewModelFactory:CurrentWeatherViewModelFactory by instance()

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this , viewModelFactory).get(CurrentWeatherViewModel::class.java)

        bindUI()

    }

    //this is a function for binding the UI
    private  fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(viewLifecycleOwner, Observer {

            if (it == null) return@Observer

                       textView.text = it.toString()

        } )
    }

}