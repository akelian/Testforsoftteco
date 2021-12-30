package by.softteco.nmisko.data.local.user


import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


data class UserLocal(

    @ColumnInfo(name = "dbId")
    @PrimaryKey(autoGenerate = true)
    val dbId : Int,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "website")
    val website: String
)