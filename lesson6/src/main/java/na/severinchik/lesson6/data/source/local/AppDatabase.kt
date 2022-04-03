package na.severinchik.lesson6.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import na.severinchik.lesson6.data.entities.Fact
import na.severinchik.lesson6.data.entities.Images

@Database(entities = [Fact::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val factDAO: FactDAO

    companion object {
        private const val DATABASE_NAME = "facts_database"

        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
    }
}