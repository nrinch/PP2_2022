package na.severinchik.lesson6.data.source.remote

import na.severinchik.lesson6.data.entities.ResponseDogImage
import retrofit2.http.GET

interface DogsImageApi {
    @GET("breeds/image/random")
    suspend fun get(): ResponseDogImage
}