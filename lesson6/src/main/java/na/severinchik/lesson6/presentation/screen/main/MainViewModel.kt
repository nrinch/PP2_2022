package na.severinchik.lesson6.presentation.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.lesson6.data.entities.Fact
import na.severinchik.lesson6.data.repository.FactsRepository
import na.severinchik.lesson6.data.source.local.AppDatabase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getInstance(application.applicationContext)
    private val repository = FactsRepository(database)

    private val mState: MutableSharedFlow<List<Fact>> = MutableSharedFlow()
    val state: SharedFlow<List<Fact>> = mState

    fun insert() {
        viewModelScope.launch {
            repository.insert(
                Fact("Cats", "Cats always hungry")
            )
        }
    }

    fun update() {
        viewModelScope.launch {
            repository.getAll().collect {
                mState.emit(it)
            }
        }
    }

}