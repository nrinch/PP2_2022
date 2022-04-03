package na.severinchik.lesson6.presentation.screen.dogscats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.data.repository.CatsDogsRepository
import na.severinchik.lesson6.data.source.remote.RetrofitClient

class DogsCatsViewModel(application: Application) : AndroidViewModel(application) {

    private val dogApi = RetrofitClient.dogsImageApi
    private val catApi = RetrofitClient.catsFactsApi

    private val repository = CatsDogsRepository(api = catApi, dogApi = dogApi)

    private val mState: MutableSharedFlow<DogsCatsState> = MutableSharedFlow()
    val state: SharedFlow<DogsCatsState> = mState

    fun fetch() {
        viewModelScope.launch {
            val link = repository.getNewImageDogs()
            val fact = repository.getNewFact()
            val state = DogsCatsState(imageLink = link, fact = fact)

            mState.emit(state)
        }
    }
}


data class DogsCatsState(
    val imageLink: String,
    val fact: String
)