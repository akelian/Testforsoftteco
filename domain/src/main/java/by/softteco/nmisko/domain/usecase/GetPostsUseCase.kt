package by.softteco.nmisko.domain.usecase

import by.softteco.nmisko.domain.model.Post

interface GetPostsUseCase {
    suspend operator fun invoke(): ArrayList<Post>
}