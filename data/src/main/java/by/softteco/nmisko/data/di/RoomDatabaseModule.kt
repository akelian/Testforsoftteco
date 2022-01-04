package by.softteco.nmisko.data.di


import android.content.Context
import androidx.room.Room
import by.softteco.nmisko.data.local.RoomLocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
 class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(bindContext: Context) =
        Room.databaseBuilder(bindContext, RoomLocalDatabase::class.java, "database").build()


}