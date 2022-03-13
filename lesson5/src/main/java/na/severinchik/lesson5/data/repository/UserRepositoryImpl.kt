package na.severinchik.lesson5.data.repository

import android.app.Application
import na.severinchik.lesson5.data.entity.UserDTO
import na.severinchik.lesson5.data.storage.local.AppDatabase
import na.severinchik.lesson5.domain.repository.UserRepository

class UserRepositoryImpl(private val application: Application) : UserRepository {

    val database by lazy { AppDatabase.getInstance(application) }

    override suspend fun fetchAll() = database.userDao.fetchAll()

    override suspend fun fetchById(id: Int) = database.userDao.fetchById(id)

    override suspend fun add(user: UserDTO) = database.userDao.add(user)

    override suspend fun update(user: UserDTO) = database.userDao.update(user)
}