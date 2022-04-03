package na.severinchik.lesson6.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.source.remote.CatFactsApi
import na.severinchik.lesson6.data.source.remote.DogsImageApi

class CatsDogsRepository(
    private val api: CatFactsApi,
    private val dogApi: DogsImageApi
) {

    suspend fun getNewFact() = withContext(Dispatchers.IO) {
        api.getNewFactAboutCat().fact
    }

    suspend fun getNewImageDogs() = withContext(Dispatchers.IO) {
        dogApi.get().message
    }
}