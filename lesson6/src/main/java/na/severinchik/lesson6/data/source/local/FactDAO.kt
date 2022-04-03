package na.severinchik.lesson6.data.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson6.data.entities.Fact

@Dao
interface FactDAO {
    @Insert
    suspend fun insert(fact: Fact)

    @Query("SELECT * FROM facts_table")
    fun getAll(): Flow<List<Fact>>

    @Update
    suspend fun update(fact: Fact)

    @Delete
    suspend fun delete(fact: Fact)

    @Query("SELECT * FROM facts_table WHERE uid IN(:uid)")
    fun getById(uid: Int): Fact
}