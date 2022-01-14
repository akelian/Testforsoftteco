package by.softteco.nmisko.data.remote

import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.remote.model.user.UserItem
import by.softteco.nmisko.data.remote.api.RemoteApi
import retrofit2.Response

class RetrofitDataSource(private val remoteApi: RemoteApi) : RemoteDataSource {
    override suspend fun getUsersById(id: Int): Response<UserItem> = remoteApi.getUsersById(id.toString())

    override suspend fun getPostList(): Response<PostResponse> = remoteApi.getPostList()
}