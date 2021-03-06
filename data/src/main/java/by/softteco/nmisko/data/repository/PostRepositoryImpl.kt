package by.softteco.nmisko.data.repository

import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.mapToDomainModel
import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.data.remote.model.post.PostItem
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.repository.PostRepository
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : PostRepository {

    override suspend fun getAllPosts(): ArrayList<Post> {
        val response: Response<PostResponse> = remoteDataSource.getPostList()
//        val response: Response<PostItem> = remoteDataSource.getPostList()
        var postList = ArrayList<Post>()
        if (response.isSuccessful) {
            val postResponse: PostResponse? = response.body()
//            val postResponse: PostItem? = response.body()
            postList = postResponse!!.mapToDomainModel()

        }
        return postList
    }


}