package by.softteco.nmisko.testforsoftteco

import android.app.Application
import by.softteco.nmisko.data.di.RetrofitModule
import by.softteco.nmisko.data.di.RoomDatabaseModule
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.data.repository.UserRepositoryImpl
import by.softteco.nmisko.testforsoftteco.ui.MainActivity
import by.softteco.nmisko.testforsoftteco.ui.fragment.MenuFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, AndroidSupportInjectionModule::class, AndroidModule::class, RoomDatabaseModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        @Named("application")
        fun application(app: Application): Builder

        fun build(): ApplicationComponent

    }


    fun getRetrofit(): RemoteApi

    fun inject(activity: MainActivity)
    fun inject(fragment: MenuFragment)
    fun inject(fragment: UserDetailsFragment)
    fun inject(userRepository: UserRepositoryImpl)
}

