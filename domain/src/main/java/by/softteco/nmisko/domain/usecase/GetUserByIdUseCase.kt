package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.model.User

interface GetUserByIdUseCase {
    suspend operator fun invoke(id : Int) : User?
}