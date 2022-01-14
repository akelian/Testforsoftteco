package by.softteco.nmisko.data.local.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserLocal(
    @ColumnInfo(name = "email")
    val email: String,
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "website")
    val website: String,
    @ColumnInfo(name = "geoLat")
    val geoLat: String,
    @ColumnInfo(name = "geoLng")
    val geoLng: String

)