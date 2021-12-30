package by.softteco.nmisko.data.local


import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.softteco.nmisko.data.model.post.PostItem
import by.softteco.nmisko.data.local.posts.PostDAO
import by.softteco.nmisko.data.local.user.UserDAO
import by.softteco.nmisko.data.local.user.UserLocal

@Database(entities = [PostItem::class, UserLocal::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract class getPostDAO() : PostDAO
    abstract class getUserDao() : UserDAO

    companion object {
        fun init(context: Context) =
            Room.databaseBuilder(context, RoomDatabase::class.java, "database").build()

    }
}