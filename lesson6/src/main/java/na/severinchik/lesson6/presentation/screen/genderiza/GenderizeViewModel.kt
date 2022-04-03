package na.severinchik.lesson6.presentation.screen.genderiza

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.data.entities.ResponseGenderize
import na.severinchik.lesson6.data.repository.GenderizeRepository
import na.severinchik.lesson6.data.repository.ResultWrapper
import na.severinchik.lesson6.data.source.remote.GenderizeApi
import na.severinchik.lesson6.data.source.remote.RetrofitClient

class GenderizeViewModel(application: Application) : AndroidViewModel(application) {

    private val api: GenderizeApi = RetrofitClient.genderizeApi
    private val repository = GenderizeRepository(api = api)

    private val mState: MutableSharedFlow<ResultWrapper<ResponseGenderize>> = MutableSharedFlow()
    val state: SharedFlow<ResultWrapper<ResponseGenderize>> = mState

    fun check(name: String) {
        viewModelScope.launch {
            mState.emit(ResultWrapper.Loading)
            mState.emit(repository.send(name = name))
        }
    }
}