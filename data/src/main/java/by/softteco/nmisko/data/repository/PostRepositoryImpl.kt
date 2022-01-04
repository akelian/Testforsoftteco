package by.softteco.nmisko.data.repository

import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.map
import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.repository.PostRepository
import retrofit2.Response

class PostRepositoryImpl(private val remoteDataSource: RemoteDataSource) : PostRepository {

    override suspend fun getAllPosts(): ArrayList<Post> {
        val response: Response<PostResponse> =  remoteDataSource.getPostList()
        var postList = ArrayList<Post>()
        if (response.isSuccessful){
            val postResponse : PostResponse? = response.body()
            postList = postResponse!!.map()

        }
        return postList
    }
}