package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.softteco.nmisko.data.LocalDataSource
import by.softteco.nmisko.data.RemoteDataSource
import by.softteco.nmisko.data.local.RoomDataSource
import by.softteco.nmisko.data.remote.RetrofitDataSource
import by.softteco.nmisko.data.repository.PostRepositoryImpl
import by.softteco.nmisko.data.repository.UserRepositoryImpl
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.domain.repository.PostRepository
import by.softteco.nmisko.domain.usecase.GetPostsUseCase
import by.softteco.nmisko.testforsoftteco.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


class MainViewModel : ViewModel() {

    private var postsList = ArrayList<Post>()
    private lateinit var user: User

    @Inject
    lateinit var getPostsUseCase: GetPostsUseCase
    @Inject
    lateinit var postRepository : PostRepository
    @Inject
    lateinit var remoteDataSource : RemoteDataSource
    @Inject
    lateinit var localDataSource: LocalDataSource
    val app = App()


    fun fetchPosts() {
        localDataSource = RoomDataSource(app.localDatabase.getPostDAO(), app.localDatabase.getUserDao())
        remoteDataSource = RetrofitDataSource(app.retrofit)
        postRepository = PostRepositoryImpl(remoteDataSource, localDataSource)
        getPostsUseCase = GetPostsUseCase(postRepository)

        viewModelScope.launch {
            postsList = getPostsUseCase.invoke()
            for (post in postsList) {
                Timber.e(post.toString())
            }
        }
    }


}