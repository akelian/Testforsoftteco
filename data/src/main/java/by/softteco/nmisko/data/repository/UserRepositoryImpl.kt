package by.softteco.nmisko.data.repository


import by.softteco.nmisko.data.local.RoomDatabase
import by.softteco.nmisko.data.map
import by.softteco.nmisko.data.model.user.UserItem
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.domain.model.User


import by.softteco.nmisko.domain.repository.UserRepository
import retrofit2.Response

class UserRepositoryImpl(private val remoteApi: RemoteApi, private val roomDatabase: RoomDatabase) :
    UserRepository {

    override suspend fun getUserByID(id: Int): User {
        val response: Response<UserItem> = remoteApi.getAllUsersById(id.toString())
        val user: User
        val userItem: UserItem? = response.body()
        user = userItem!!.map()
        return user

    }

    override suspend fun saveUser(user: User) {
//        roomDatabase.init()
    }


}