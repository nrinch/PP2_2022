package na.severinchik.lesson5.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson5.App
import na.severinchik.lesson5.data.entity.UserDTO
import na.severinchik.lesson5.data.repository.UserRepositoryImpl
import na.severinchik.lesson5.domain.interactor.UserInteractor
import na.severinchik.lesson5.domain.repository.UserRepository
import na.severinchik.lesson5.domain.usecases.AddUserUseCase
import na.severinchik.lesson5.domain.usecases.AddUserUseCaseImpl
import na.severinchik.lesson5.domain.usecases.GetUserUseCase
import na.severinchik.lesson5.domain.usecases.GetUserUseCaseImpl
import na.severinchik.lesson5.presentation.listadapter.User

class CleanArchitectureExampleViewModel(application: Application) : AndroidViewModel(application) {

//    private val interactor = getApplication<App>().interactor

    val userRepository: UserRepository = UserRepositoryImpl(application)

    val addUserUseCase: AddUserUseCase = AddUserUseCaseImpl(userRepository)
    val getUserUseCase: GetUserUseCase = GetUserUseCaseImpl(userRepository)

    val interactor: UserInteractor =
        UserInteractor(
            addUserUseCase = addUserUseCase,
            getUserUseCase = getUserUseCase
        )


    private val mState: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
    val state: StateFlow<List<User>> = mState

    fun fetchAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mState.emit(
                interactor.fetchAll()
                    .map { userDTO -> User(id = userDTO.id, name = userDTO.name, userDTO.surname) }
            )
        }
    }

    fun add(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.add(
                UserDTO(
                    id = user.id,
                    name = user.name,
                    surname = user.surname,
                    birthDay = String.EMPTY,
                    mobilePhoneNumber = String.EMPTY
                )
            )
        }
    }
}


val String.Companion.EMPTY
    get() = ""