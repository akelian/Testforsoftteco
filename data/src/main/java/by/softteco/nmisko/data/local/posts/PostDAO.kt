package by.softteco.nmisko.data.local.posts


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostLocal)

    @Query("SELECT * FROM post_table")
    suspend fun getAllPosts() : List<PostLocal>

}