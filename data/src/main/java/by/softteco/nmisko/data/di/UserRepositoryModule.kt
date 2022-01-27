package by.softteco.nmisko.data.di

import by.softteco.nmisko.data.repository.UserRepositoryImpl
import by.softteco.nmisko.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserRepository(repository : UserRepositoryImpl) : UserRepository
}