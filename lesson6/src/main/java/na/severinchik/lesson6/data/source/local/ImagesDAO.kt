package na.severinchik.lesson6.data.source.local

import androidx.room.Dao
import androidx.room.Query
import na.severinchik.lesson6.data.entities.Images

@Dao
interface ImagesDAO {
    @Query("SELECT * FROM images_table WHERE name IN(:name)")
    suspend fun getByName(name:String):Images
}