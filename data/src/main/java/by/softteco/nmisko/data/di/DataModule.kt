package by.softteco.nmisko.data.di

import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.local.RoomDataSource
import by.softteco.nmisko.data.local.RoomLocalDatabase
import by.softteco.nmisko.data.remote.RetrofitDataSource
import by.softteco.nmisko.data.remote.api.RemoteApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(roomLocalDatabase: RoomLocalDatabase): LocalDataSource =
        RoomDataSource(roomLocalDatabase.getPostDAO(), roomLocalDatabase.getUserDAO())

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteApi: RemoteApi): RemoteDataSource =
        RetrofitDataSource(remoteApi)

}