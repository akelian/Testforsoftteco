package by.softteco.nmisko.data

import by.softteco.nmisko.data.remote.model.user.UserItem
import by.softteco.nmisko.data.remote.PostResponse
import dagger.Provides
import retrofit2.Response

interface RemoteDataSource  {

    suspend fun getUsersById(id: Int) : Response<UserItem>
    suspend fun getPostList() : Response<PostResponse>
}