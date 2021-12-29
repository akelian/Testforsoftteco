package by.softteco.nmisko.core.data.remote.api

import by.softteco.nmisko.core.data.entity.post.PostsResponse
import by.softteco.nmisko.core.data.entity.user.UserResponse
import by.softteco.nmisko.core.data.entity.user.UserResponseItem
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/users")
    fun getAllUsers() : Deferred<Response<UserResponse>>

    @GET("/users/{userId}")
    fun getAllUsersById(@Path("userId")userId: String) : Deferred<Response<UserResponseItem>>

    @GET("/posts")
    fun getPostList(): Deferred<Response<PostsResponse>>
}