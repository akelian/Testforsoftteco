package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User
import by.softteco.nmisko.data.usecase.GetPostsUseCaseImpl
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class MainViewModel : ViewModel() {

     var postsList = ArrayList<Post>()
     lateinit var user: User

     @Inject
     lateinit var getPostsUseCaseImpl: GetPostsUseCaseImpl


    fun fetchPosts() {
        viewModelScope.launch {
            postsList = getPostsUseCaseImpl.invoke()
            for (post in postsList) {
                Timber.e(post.toString())
            }
        }
    }


}