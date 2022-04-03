package na.severinchik.lesson6.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.entities.ResponseGenderize
import na.severinchik.lesson6.data.source.remote.GenderizeApi

class GenderizeRepository(private val api: GenderizeApi) {

    suspend fun send(name: String): ResultWrapper<ResponseGenderize> = withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(api.send(name))
        } catch (t: Throwable) {
            ResultWrapper.Error(t.message ?: "Error")
        }

    }
}


sealed class ResultWrapper<out T> {
    object Loading : ResultWrapper<Nothing>()
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error(val message: String) : ResultWrapper<Nothing>()
}