package na.severinchik.lesson5

import android.app.Application
import na.severinchik.lesson5.data.repository.DataRepository
import na.severinchik.lesson5.data.repository.UserRepositoryImpl
import na.severinchik.lesson5.domain.interactor.UserInteractor
import na.severinchik.lesson5.domain.repository.UserRepository
import na.severinchik.lesson5.domain.usecases.AddUserUseCase
import na.severinchik.lesson5.domain.usecases.AddUserUseCaseImpl
import na.severinchik.lesson5.domain.usecases.GetUserUseCase
import na.severinchik.lesson5.domain.usecases.GetUserUseCaseImpl

class App : Application() {

    val repository: DataRepository by lazy { DataRepository() }


    //Clean Arch
//    val userRepository: UserRepository by lazy { UserRepositoryImpl(applicationContext) }
//
//    val addUserUseCase: AddUserUseCase by lazy { AddUserUseCaseImpl(userRepository) }
//    val getUserUseCase: GetUserUseCase by lazy { GetUserUseCaseImpl(userRepository) }
//
//    val interactor: UserInteractor by lazy {
//        UserInteractor(
//            addUserUseCase = addUserUseCase,
//            getUserUseCase = getUserUseCase
//        )
//    }

    override fun onCreate() {
        super.onCreate()
    }
}