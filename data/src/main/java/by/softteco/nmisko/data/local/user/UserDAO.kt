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

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers() : List<UserLocal>
    @Query("SELECT * FROM user_table where id = :id")
    suspend fun getUserById(id : Int) : UserLocal

}