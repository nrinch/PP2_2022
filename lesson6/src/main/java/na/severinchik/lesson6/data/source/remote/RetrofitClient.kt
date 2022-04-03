package na.severinchik.lesson6.data.source.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_CATS = "https://catfact.ninja/"
private const val BASE_URL_DOGS = "https://dog.ceo/api/"
private const val BASE_URL_GENDERIZE = "https://api.genderize.io"

object RetrofitClient {

    val interceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private fun getInstanceCatApi(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_CATS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    private fun getInstanceDogApi(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_DOGS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    private fun getInstanceGenderizeApi(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_GENDERIZE)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val catsFactsApi: CatFactsApi
        get() = getInstanceCatApi().create(CatFactsApi::class.java)

    val dogsImageApi: DogsImageApi
        get() = getInstanceDogApi().create(DogsImageApi::class.java)

    val genderizeApi: GenderizeApi
        get() = getInstanceGenderizeApi().create(GenderizeApi::class.java)
}