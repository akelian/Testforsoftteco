package by.softteco.nmisko.data.usecase

import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.repository.PostRepository
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import javax.inject.Inject

class GetPostsUseCaseImpl @Inject constructor(private val postRepository: PostRepository) : GetPostsUseCase {
    override suspend operator fun invoke(): ArrayList<Post>? = postRepository.getAllPosts()
}