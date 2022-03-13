package na.severinchik.lesson5.domain.usecases

import na.severinchik.lesson5.data.entity.UserDTO

interface GetUserUseCase {
    suspend fun fetchById(id: Int): UserDTO
    suspend fun fetchAll(): List<UserDTO>
}