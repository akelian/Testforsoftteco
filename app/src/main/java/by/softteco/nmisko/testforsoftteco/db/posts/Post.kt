package by.softteco.nmisko.testforsoftteco.db.posts

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "post_table")
data class Post(
    @ColumnInfo(name = "body")
    val body: String,
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name ="userId")
    val userId: Int
)