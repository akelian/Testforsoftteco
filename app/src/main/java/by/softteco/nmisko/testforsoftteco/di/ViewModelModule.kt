package by.softteco.nmisko.testforsoftteco.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.ViewModelFactory
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Singleton
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
}