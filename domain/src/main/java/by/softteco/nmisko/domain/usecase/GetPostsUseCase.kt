package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend operator fun invoke() = postRepository.getAllPosts()
}