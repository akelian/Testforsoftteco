package by.softteco.nmisko.domain.repository

interface UserRepository() {
    fun getUserByID(id : Int)

    fun saveUser
}