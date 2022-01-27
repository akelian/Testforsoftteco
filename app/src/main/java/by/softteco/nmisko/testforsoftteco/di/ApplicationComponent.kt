package by.softteco.nmisko.testforsoftteco.di

import android.app.Application
import by.softteco.nmisko.data.di.*
import by.softteco.nmisko.data.local.RoomLocalDatabase
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import by.softteco.nmisko.domain.usecase.GetUserByIdUseCase
import by.softteco.nmisko.domain.usecase.SaveUserInDBUseCase
import by.softteco.nmisko.testforsoftteco.App
import by.softteco.nmisko.testforsoftteco.ui.activity.MainActivity
import by.softteco.nmisko.testforsoftteco.ui.fragment.MenuFragment
import by.softteco.nmisko.testforsoftteco.ui.fragment.PostItemFragment
import by.softteco.nmisko.testforsoftteco.ui.fragment.UserDetailsFragment
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, AndroidSupportInjectionModule::class,
    AndroidModule::class, RoomDatabaseModule::class, PostRepositoryModule::class,
    UserRepositoryModule::class, DataModule::class, UseCaseModule::class, ViewModelModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        @Named("application")
        fun application(app: Application): Builder

        fun build(): ApplicationComponent

    }

    fun getRetrofit(): RemoteApi
    fun getLocalDatabase(): RoomLocalDatabase
    fun getPostsUseCase(): GetPostsUseCase
    fun getUserByIDUseCase(): GetUserByIdUseCase
    fun saveUserInDBUseCase(): SaveUserInDBUseCase

    fun inject(activity: MainActivity)
    fun inject(fragment: MenuFragment)
    fun inject(fragment: UserDetailsFragment)
    fun inject(model: MainViewModel)
    fun inject(fragment : PostItemFragment)

}

