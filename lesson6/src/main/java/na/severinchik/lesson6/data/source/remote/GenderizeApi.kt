package na.severinchik.lesson6.data.source.remote

import na.severinchik.lesson6.data.entities.ResponseGenderize
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GenderizeApi {

    @GET("/")
    suspend fun send(@Query("name") name: String): ResponseGenderize
}