package by.softteco.nmisko.testforsoftteco.db.posts



import androidx.room.Database
import androidx.room.RoomDatabase
import by.softteco.nmisko.core.data.entity.post.Post

@Database(entities = [Post::class], version = 1)
abstract class PostsRoomDatabase : RoomDatabase() {
    abstract class postDao() : PostDAO
}