package by.softteco.nmisko.data.repository

import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.mapToDomainModel
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : PostRepository, BaseRepository() {

//    override suspend fun getAllPosts(): ArrayList<Post?>? {
//        val response: Response<PostResponse> = remoteDataSource.getPostList()
//        val postList: ArrayList<Post?>?
//        val postResponse: PostResponse? = response.body()
//        postList = postResponse?.mapToDomainModel()
//        return postList
//    }

    override suspend fun getAllPosts(): ArrayList<Post>? {
        val postResponse = safeApiCall(call = suspend { remoteDataSource.getPostList() },
            errorMessage = "Error fetching PostList")
        return postResponse?.mapToDomainModel()
    }


}