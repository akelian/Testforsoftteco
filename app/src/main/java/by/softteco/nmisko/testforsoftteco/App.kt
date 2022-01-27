package by.softteco.nmisko.testforsoftteco

import android.app.Application
import by.softteco.nmisko.data.local.RoomLocalDatabase
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.testforsoftteco.di.ApplicationComponent
import by.softteco.nmisko.testforsoftteco.di.DaggerApplicationComponent
import javax.inject.Inject
import timber.log.Timber




class App : Application() {
    private lateinit var applicationComponent : ApplicationComponent



    override fun onCreate() {
        super.onCreate()
        val app = applicationContext as App
        app.getComponent()
        Timber.plant(Timber.DebugTree())
    }


     fun getComponent(): ApplicationComponent {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()

        return applicationComponent
    }

}