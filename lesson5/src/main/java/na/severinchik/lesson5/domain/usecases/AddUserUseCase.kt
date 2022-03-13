package na.severinchik.lesson5.domain.usecases

import na.severinchik.lesson5.data.entity.UserDTO

interface AddUserUseCase {
   suspend fun add(user: UserDTO)
}