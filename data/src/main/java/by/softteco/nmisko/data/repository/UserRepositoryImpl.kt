package by.softteco.nmisko.data.repository


import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.mapToDomainModel
import by.softteco.nmisko.data.mapToRoomModel
import by.softteco.nmisko.data.remote.model.user.UserItem
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : UserRepository {


    override suspend fun getUserByID(id: Int): User {
        val response: Response<UserItem> = remoteDataSource.getUsersById(id)
        val user: User
        val userItem: UserItem? = response.body()
        user = userItem!!.mapToDomainModel()
        return user
    }


    override suspend fun saveUser(user: User) {
        localDataSource.insertUser(user = user.mapToRoomModel())
    }


}