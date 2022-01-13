package by.softteco.nmisko.testforsoftteco

import android.app.Application
import by.softteco.nmisko.data.local.RoomLocalDatabase
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.testforsoftteco.di.ApplicationComponent
import by.softteco.nmisko.testforsoftteco.di.DaggerApplicationComponent
import javax.inject.Inject

class App : Application() {
    private lateinit var applicationComponent : ApplicationComponent

    @Inject
    lateinit var retrofit : RemoteApi
    @Inject
    lateinit var localDatabase: RoomLocalDatabase

    override fun onCreate() {
        super.onCreate()
        val app = applicationContext as App
        retrofit = app.getComponent().getRetrofit()
        localDatabase = app.getComponent().getLocalDatabase()
    }


    private fun getComponent(): ApplicationComponent {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()

        return applicationComponent
    }

}