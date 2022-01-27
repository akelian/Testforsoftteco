package by.softteco.nmisko.data.usecase

import by.softteco.nmisko.domain.repository.UserRepository
import by.softteco.nmisko.domain.usecase.GetUserByIdUseCase
import javax.inject.Inject

class GetUserByIdUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    GetUserByIdUseCase {
    override suspend operator fun invoke(id: Int) = userRepository.getUserByID(id)

}