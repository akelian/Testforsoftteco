package by.softteco.nmisko.data.local

import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.local.posts.PostDAO
import by.softteco.nmisko.data.local.posts.PostLocal
import by.softteco.nmisko.data.local.user.UserDAO
import by.softteco.nmisko.data.local.user.UserLocal
import kotlinx.coroutines.flow.Flow

class RoomDataSource(private val postDAO: PostDAO, private val userDAO: UserDAO) :LocalDataSource {


    override suspend fun getPostList(): Flow<PostLocal> = postDAO.getAllPosts()
    override suspend fun insertUser(user: UserLocal) {
        userDAO.insertUser(user)
    }


}