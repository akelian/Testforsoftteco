package by.softteco.nmisko.testforsoftteco

import android.app.Application
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.data.remote.retrofit.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, AndroidSupportInjectionModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ApplicationComponent

    }

    fun getRetrofit(): RemoteApi

}

