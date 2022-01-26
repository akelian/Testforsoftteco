package by.softteco.nmisko.data.local

import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.local.posts.PostDAO
import by.softteco.nmisko.data.local.posts.PostLocal
import by.softteco.nmisko.data.local.user.UserDAO
import by.softteco.nmisko.data.local.user.UserLocal

class RoomDataSource(private val postDAO: PostDAO, private val userDAO: UserDAO) :LocalDataSource {


    override suspend fun getPostList(): List<PostLocal> = postDAO.getAllPosts()
    override suspend fun insertUser(user: UserLocal) {
        userDAO.insertUser(user)
    }

    override suspend fun getUserById(id: Int): UserLocal = userDAO.getUserById(id)



}