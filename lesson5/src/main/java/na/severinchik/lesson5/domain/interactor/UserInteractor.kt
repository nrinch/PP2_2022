package na.severinchik.lesson5.domain.interactor

import na.severinchik.lesson5.domain.usecases.AddUserUseCase
import na.severinchik.lesson5.domain.usecases.GetUserUseCase

class UserInteractor(
    private val addUserUseCase: AddUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : AddUserUseCase by addUserUseCase,
    GetUserUseCase by getUserUseCase {
}