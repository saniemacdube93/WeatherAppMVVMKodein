package za.co.krd.macweatherapper.ui.weather.Future.List

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import za.co.krd.macweatherapper.R

class FureListWeather : Fragment() {

    companion object {
        fun newInstance() = FureListWeather()
    }

    private lateinit var viewModel: FureListWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fure_list_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FureListWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}