package by.softteco.nmisko.data.di

import by.softteco.nmisko.data.usecase.GetPostsUseCaseImpl
import by.softteco.nmisko.data.usecase.GetUserByIdUseCaseImpl
import by.softteco.nmisko.data.usecase.SaveUserInDBUseCaseImpl
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import by.softteco.nmisko.domain.usecase.GetUserByIdUseCase
import by.softteco.nmisko.domain.usecase.SaveUserInDBUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindGetPostsUseCase(getPostsUseCaseImpl: GetPostsUseCaseImpl) : GetPostsUseCase

    @Binds
    @Singleton
    abstract fun bindGetUserByIDUseCase(getUserByIdUseCaseImpl: GetUserByIdUseCaseImpl) : GetUserByIdUseCase

    @Binds
    @Singleton
    abstract fun bindSaveUserInDBUseCase(saveUserInDBUseCaseImpl: SaveUserInDBUseCaseImpl) : SaveUserInDBUseCase

}