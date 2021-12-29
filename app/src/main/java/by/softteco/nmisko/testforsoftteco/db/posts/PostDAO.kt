package by.softteco.nmisko.testforsoftteco.db.posts


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.softteco.nmisko.core.data.entity.post.PostsResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostsResponse)

    @Query("SELECT * FROM post_table")
    suspend fun getAllPosts() : Flow<PostsResponse>

}