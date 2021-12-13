package za.co.krd.macweatherapper.ui.weather.Current

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import za.co.krd.macweatherapper.R
import za.co.krd.macweatherapper.data.adapter.MyAdapter
import za.co.krd.macweatherapper.data.enity2.User
import za.co.krd.macweatherapper.ui.base.ScopedFragment

class CurrentWeatherFragment : ScopedFragment() , KodeinAware{
    //we are using Kodein for our dependency injection
    override val kodein by closestKodein()
   private val viewModelFactory:CurrentWeatherViewModelFactory by instance()
    private lateinit var userArrayList: ArrayList<User>
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
            group_loading.visibility = View.GONE

         //   updateTemperature(it.temp.toString(), it.tempMin.toString() , it.tempMax.toString())
          //  updateTemperature(it.list.get(0).dtTxt, it.list.get(0).dtTxt, it.list.get(0).dtTxt,)

//            val imageId = intArrayOf(
//                    R.drawable.humidity, R.drawable.pressure , R.drawable.sunset ,R.drawable.sunset, R.drawable.pressure, R.drawable.pressure, R.drawable.pressure
//            )








            userArrayList = ArrayList()

            for (i in it.list.indices ){
                val user = User(it.list.get(i).main.temp.toString(),it.list.get(i).dtTxt,it.list.get(i).main.temp.toString(),it.list.get(i).main.temp.toString(),it.list.get(i).main.temp.toString())
                userArrayList.add(user)
            }



            listView.adapter = MyAdapter(parentFragment?.context as Activity,userArrayList)


        } )
    }






//    private fun updateTemperature(temperature: String , minimumTemp: String  , maxTemp:String){
//        temp.text = "$temperature°C"
//        temp_min.text = "Min Temp:"+"$minimumTemp°C"
//        temp_max.text = "Max Temp:"+"$maxTemp°C"
//    }

}