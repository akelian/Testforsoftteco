package by.softteco.nmisko.domain.repository

import by.softteco.nmisko.domain.model.Post


interface PostRepository  {

    suspend fun getAllPosts() : ArrayList<Post?>?

}