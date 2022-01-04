package by.softteco.nmisko.data.di

import by.softteco.nmisko.data.repository.PostRepositoryImpl
import by.softteco.nmisko.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class PostRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPostRepository(repository : PostRepositoryImpl) : PostRepository
}