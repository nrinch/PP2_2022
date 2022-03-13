package na.severinchik.lesson5.domain.usecases

import na.severinchik.lesson5.data.entity.UserDTO
import na.severinchik.lesson5.domain.repository.UserRepository

class GetUserUseCaseImpl(private val userRepository: UserRepository) : GetUserUseCase {
    override suspend fun fetchById(id: Int): UserDTO = userRepository.fetchById(id)

    override suspend fun fetchAll(): List<UserDTO> = userRepository.fetchAll()
}