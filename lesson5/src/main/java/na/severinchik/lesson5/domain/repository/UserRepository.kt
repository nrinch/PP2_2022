package na.severinchik.lesson5.domain.repository

import na.severinchik.lesson5.data.entity.UserDTO

interface UserRepository {
    suspend fun fetchAll(): List<UserDTO>
    suspend fun fetchById(id: Int): UserDTO
    suspend fun add(user: UserDTO)
    suspend fun update(user: UserDTO)
}