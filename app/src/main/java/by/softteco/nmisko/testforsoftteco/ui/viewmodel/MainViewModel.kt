package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.local.user.UserLocal
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import by.softteco.nmisko.domain.usecase.GetUserByIdUseCase
import by.softteco.nmisko.domain.usecase.SaveUserInDBUseCase
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


class MainViewModel @Inject constructor(private var getPostsUseCase: GetPostsUseCase, private var getUserByIdUseCase: GetUserByIdUseCase, private var saveUserInDBUseCase: SaveUserInDBUseCase, var localDataSource: LocalDataSource) : ViewModel() {

    private var postsList = ArrayList<Post>()
    private lateinit var user: User

     suspend fun fetchPosts() {
         withContext(viewModelScope.coroutineContext) {
             postsList = getPostsUseCase()
         }.also { Timber.e("Done") }
    }

    suspend fun fetchUserById(id :Int){
        withContext(viewModelScope.coroutineContext){
           user = getUserByIdUseCase(id)
        }
    }

    fun getPosts(): ArrayList<Post> {
        return postsList
    }

    fun getUser(): User {
        return user
    }

    suspend fun insertUserInDb(user: User){
        withContext(viewModelScope.coroutineContext){
            saveUserInDBUseCase(user)
        }
    }

    suspend fun getUserByIdFromRoom(id: Int) : UserLocal{
        val user : UserLocal
        withContext(viewModelScope.coroutineContext){
            user =   localDataSource.getUserById(id)
        }
        return user
    }
}