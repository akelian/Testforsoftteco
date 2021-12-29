package by.softteco.nmisko.testforsoftteco

import android.app.Application
import android.util.Log
import by.softteco.nmisko.core.data.remote.api.RemoteApi
import javax.inject.Inject

class App : Application() {
    private lateinit var applicationComponent :ApplicationComponent

    @Inject
    lateinit var retrofit : RemoteApi

    override fun onCreate() {
        super.onCreate()
        val app = applicationContext as App
        retrofit = app.getComponent().getRetrofit()
    /*app.getComponent().getRetrofit().also { Log.e("STARTUP", "retrofit initialized") }*/

    }

    private fun getComponent(): ApplicationComponent{
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()

        return applicationComponent
    }
}