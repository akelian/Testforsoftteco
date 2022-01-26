package by.softteco.nmisko.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import by.softteco.nmisko.data.local.posts.PostDAO
import by.softteco.nmisko.data.local.posts.PostLocal
import by.softteco.nmisko.data.local.user.UserDAO
import by.softteco.nmisko.data.local.user.UserLocal

@Database(entities = [PostLocal::class, UserLocal::class], version = 2)
abstract class RoomLocalDatabase : RoomDatabase() {
    abstract fun getPostDAO() : PostDAO
    abstract fun getUserDAO() : UserDAO

}