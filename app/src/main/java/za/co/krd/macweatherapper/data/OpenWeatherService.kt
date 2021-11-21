package za.co.krd.macweatherapper.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import za.co.krd.macweatherapper.data.response.CurrentWeatherResponse
import za.co.krd.macweatherapper.network.ConnectivityInterceptor


const val API_KEY = "034da672af3e87a27b2bfb04a03baaa1"
//https://api.openweathermap.org/data/2.5/weather?appid=034da672af3e87a27b2bfb04a03baaa1&q=harare

interface OpenWeatherService {
    @GET("weather")
    fun  getCurrentWeather (
        @Query("q") city: String,
    ): Deferred<CurrentWeatherResponse>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: ConnectivityInterceptor

        ): OpenWeatherService{
            val requestInterceptor = Interceptor { chain ->


                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
               .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenWeatherService::class.java)

        }
    }
}

