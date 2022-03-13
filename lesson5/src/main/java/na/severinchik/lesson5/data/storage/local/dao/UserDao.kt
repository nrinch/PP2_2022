package na.severinchik.lesson5.data.storage.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import na.severinchik.lesson5.data.entity.UserDTO

@Dao
interface UserDao {
    @Query("SELECT * FROM userdto")
    fun fetchAll(): List<UserDTO>

    @Query("SELECT * FROM userdto WHERE id in (:id)")
    fun fetchById(id: Int): UserDTO

    @Insert
    fun add(user: UserDTO)

    @Update
    fun update(user: UserDTO)

}