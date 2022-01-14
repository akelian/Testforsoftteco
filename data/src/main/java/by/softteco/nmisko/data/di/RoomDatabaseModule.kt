package by.softteco.nmisko.data.di


import android.content.Context
import androidx.room.Room
import by.softteco.nmisko.data.local.RoomLocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(context: Context) : RoomLocalDatabase =
        Room.databaseBuilder(context, RoomLocalDatabase::class.java, "database").build()


}