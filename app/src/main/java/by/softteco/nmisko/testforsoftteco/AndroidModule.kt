package by.softteco.nmisko.testforsoftteco

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AndroidModule {

    @Binds
    abstract fun bindContext(app: Application) : Context


}