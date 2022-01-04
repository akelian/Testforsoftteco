package by.softteco.nmisko.data.repository


import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.map
import by.softteco.nmisko.data.model.user.UserItem
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.UserRepository
import retrofit2.Response

class UserRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) :
    UserRepository {


    override suspend fun getUserByID(id: Int): User {
        val response: Response<UserItem> = remoteDataSource.getUsersById(id)
        val user: User
        val userItem: UserItem? = response.body()
        user = userItem!!.map()
        return user
    }


    override suspend fun saveUser(user: User) {
        localDataSource.getPostList()
    }


}