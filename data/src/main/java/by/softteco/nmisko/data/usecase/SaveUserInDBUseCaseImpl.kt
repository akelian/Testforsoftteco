package by.softteco.nmisko.data.usecase

import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.UserRepository
import by.softteco.nmisko.domain.usecase.SaveUserInDBUseCase
import javax.inject.Inject

class SaveUserInDBUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    SaveUserInDBUseCase {
    override suspend operator fun invoke(user: User) = userRepository.saveUser(user)
}