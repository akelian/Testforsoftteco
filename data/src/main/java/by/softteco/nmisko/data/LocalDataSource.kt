package by.softteco.nmisko.data

import by.softteco.nmisko.data.local.posts.PostLocal
import by.softteco.nmisko.data.local.user.UserLocal


interface LocalDataSource {
    suspend fun getPostList() : List<PostLocal>
    suspend fun insertUser(user: UserLocal)
}