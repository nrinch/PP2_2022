package na.severinchik.lesson5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel : ViewModel() {

    private val mState: MutableStateFlow<String> = MutableStateFlow("Loading...")
    val state: StateFlow<String> = mState

    fun fetchData() {
        viewModelScope.launch {
            mState.emit("Success")
        }
    }
}


//
//class MainViewModel(application: Application)/*(private val index: Int)*/ :
//    AndroidViewModel(application) {
//
//    fun getRandomText(): String = "Hello!"
//
//    fun todoSmthWithApplication() = getApplication<App>().repository.fetchData()
//
//}


class MainViewModelFactory(private val index: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            MainViewModel(index)
        } else {
            throw IllegalArgumentException("not correct data provided")
        }
        return viewModel as T
    }

}