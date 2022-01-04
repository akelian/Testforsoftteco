package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserInDBUseCase @Inject constructor(private val userRepository: UserRepository){
    suspend operator fun invoke(user: User) = userRepository.saveUser(user)
}