package na.severinchik.lesson6.data.source.remote

import na.severinchik.lesson6.data.entities.ResponseCatFact
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CatFactsApi {
    @GET("fact")
    suspend fun getNewFactAboutCat():ResponseCatFact

}