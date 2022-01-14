package by.softteco.nmisko.testforsoftteco.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module


@Module
abstract class AndroidModule {

    @Binds
    abstract fun bindContext(app: Application) : Context


}