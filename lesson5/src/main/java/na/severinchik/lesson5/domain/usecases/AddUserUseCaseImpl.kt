package na.severinchik.lesson5.domain.usecases

import na.severinchik.lesson5.data.entity.UserDTO
import na.severinchik.lesson5.domain.repository.UserRepository

class AddUserUseCaseImpl(private val userRepository: UserRepository) : AddUserUseCase {
    override suspend fun add(user: UserDTO) {
        userRepository.add(user)
    }
}