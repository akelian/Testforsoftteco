package by.softteco.nmisko.data.remote.api

import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.data.remote.UserResponse
import by.softteco.nmisko.data.model.user.UserItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/users")
    suspend fun getAllUsers() : Response<UserResponse>

    @GET("/users/{userId}")
    suspend fun getUsersById(@Path("userId")userId: String) : Response<UserItem>

    @GET("/posts")
    suspend fun getPostList(): Response<PostResponse>
}