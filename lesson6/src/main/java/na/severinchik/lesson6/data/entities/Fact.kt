package na.severinchik.lesson6.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facts_table")
data class Fact(
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "message") val message: String,
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
