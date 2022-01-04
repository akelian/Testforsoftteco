package by.softteco.nmisko.data

import by.softteco.nmisko.data.local.posts.PostLocal
import by.softteco.nmisko.data.local.user.UserLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getPostList() : Flow<PostLocal>
    suspend fun insertUser(user: UserLocal)
}