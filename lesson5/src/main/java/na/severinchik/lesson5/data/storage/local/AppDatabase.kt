package na.severinchik.lesson5.data.storage.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import na.severinchik.lesson5.data.entity.UserDTO
import na.severinchik.lesson5.data.storage.local.dao.UserDao

@Database(entities = [UserDTO::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        const val NAME = "app_database"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(application: Application): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    NAME
                ).fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}