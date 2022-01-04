package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(id : Int) = userRepository.getUserByID(id)

}