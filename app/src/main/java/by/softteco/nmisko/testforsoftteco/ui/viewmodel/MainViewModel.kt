package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.local.RoomDataSource
import by.softteco.nmisko.data.remote.RetrofitDataSource
import by.softteco.nmisko.data.repository.PostRepositoryImpl
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.PostRepository
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import by.softteco.nmisko.testforsoftteco.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class MainViewModel : ViewModel() {

     var postsList = ArrayList<Post>()
     lateinit var user: User

     @Inject
     lateinit var getPostsUseCase: GetPostsUseCase


    fun fetchPosts() {
        viewModelScope.launch {
            postsList = getPostsUseCase.invoke()
            for (post in postsList) {
                Timber.e(post.toString())
            }
        }
    }


}