package by.softteco.nmisko.domain.repository

import by.softteco.nmisko.domain.model.User

interface UserRepository {
    suspend fun getUserByID(id : Int) : User

    suspend fun saveUser(user : User)
}