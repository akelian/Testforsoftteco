package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.model.User

interface SaveUserInDBUseCase {
    suspend operator fun invoke(user : User)
}