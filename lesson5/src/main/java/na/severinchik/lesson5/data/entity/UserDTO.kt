package na.severinchik.lesson5.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "surname")
    val surname: String,
    @ColumnInfo(name = "birthday")
    val birthDay: String,
    @ColumnInfo(name = "mobilePhoneNumber")
    val mobilePhoneNumber: String
)
