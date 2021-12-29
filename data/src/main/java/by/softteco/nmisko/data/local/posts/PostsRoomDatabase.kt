package by.softteco.nmisko.data.local.posts



import androidx.room.Database
import androidx.room.RoomDatabase
import by.softteco.nmisko.data.entity.post.Post

@Database(entities = [Post::class], version = 1)
abstract class PostsRoomDatabase : RoomDatabase() {
    abstract class postDao() : PostDAO
}