package by.softteco.nmisko.data.remote.api

import by.softteco.nmisko.data.entity.post.PostsResponse
import by.softteco.nmisko.data.entity.user.UserResponse
import by.softteco.nmisko.data.entity.user.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/users")
    fun getAllUsers() : Deferred<Response<UserResponse>>

    @GET("/users/{userId}")
    fun getAllUsersById(@Path("userId")userId: String) : Deferred<Response<User>>

    @GET("/posts")
    fun getPostList(): Deferred<Response<PostsResponse>>
}