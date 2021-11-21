package za.co.krd.macweatherapper

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import za.co.krd.macweatherapper.data.OpenWeatherService
import za.co.krd.macweatherapper.data.db.ForecastDatabase
import za.co.krd.macweatherapper.data.repository.ForecastRepository
import za.co.krd.macweatherapper.data.repository.ForecastRepositoryImpl
import za.co.krd.macweatherapper.network.ConnectivityInterceptor
import za.co.krd.macweatherapper.network.ConnectivityInterceptorImpl
import za.co.krd.macweatherapper.network.WeatherNetworkDataSource
import za.co.krd.macweatherapper.network.WeatherNetworkDataSourceImpl
import za.co.krd.macweatherapper.ui.weather.Current.CurrentWeatherViewModelFactory

//we using Kodein for dependecny injection
class ForecastApplication : Application() , KodeinAware {
    override val  kodein = Kodein.lazy {
        //androidXModule provides us with instances of context without having to write much code
        import(androidXModule(this@ForecastApplication ))
        //we are binding our forecast database
        bind() from singleton{ ForecastDatabase.invoke(instance()) }
        //binding the DAO
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        //binding the network connection interceptor interface with a singleton
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance())}
        //binding the Open Weather service
        bind() from singleton { OpenWeatherService(instance()) }
        //binding the Network DataSource
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        //binding the forecast repository
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance()) }
        //binding the view model factory
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

    }


}