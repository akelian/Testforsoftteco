package by.softteco.nmisko.data.repository

import by.softteco.nmisko.data.map
import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.repository.PostRepository
import retrofit2.Response

class PostRepository(private val remoteApi : RemoteApi) : PostRepository {

    override suspend fun getAllPosts(): ArrayList<Post> {
        val response: Response<PostResponse> =  remoteApi.getPostList()
        var postList = ArrayList<Post>()
        if (response.isSuccessful){
            val postResponse : PostResponse? = response.body()
            postList = postResponse!!.map()

        }
        return postList
    }
}