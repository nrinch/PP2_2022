package na.severinchik.lesson6.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.entities.Fact
import na.severinchik.lesson6.data.source.local.AppDatabase

class FactsRepository(private val database: AppDatabase) {

    suspend fun insert(fact: Fact) {
        withContext(Dispatchers.IO) {
            database.factDAO.insert(fact)
        }
    }

    suspend fun getAll(): Flow<List<Fact>> {
        return withContext(Dispatchers.IO) {
            database.factDAO.getAll()
        }
    }
}