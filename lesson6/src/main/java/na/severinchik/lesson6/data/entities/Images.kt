package na.severinchik.lesson6.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "images_table")
data class Images(
    val name: String,
    val path: String
)
