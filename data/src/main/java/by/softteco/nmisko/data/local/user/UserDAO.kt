package by.softteco.nmisko.data.local.user


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserLocal)

    @Query("SELECT * FROM post_table")
    suspend fun getAllUsers() : Flow<UserLocal>
    @Query("SELECT * FROM post_table")
    suspend fun getUserById() : Flow<UserLocal>

}