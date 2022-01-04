package by.softteco.nmisko.testforsoftteco

import android.app.Application
import android.content.Context
import by.softteco.nmisko.data.remote.api.RemoteApi
import dagger.Binds
import dagger.Provides
import javax.inject.Inject

class App : Application() {
    private lateinit var applicationComponent :ApplicationComponent

    @Inject
    lateinit var retrofit : RemoteApi

    override fun onCreate() {
        super.onCreate()
        val app = applicationContext as App
        retrofit = app.getComponent().getRetrofit()


    }


    private fun getComponent(): ApplicationComponent{
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()

        return applicationComponent
    }

}