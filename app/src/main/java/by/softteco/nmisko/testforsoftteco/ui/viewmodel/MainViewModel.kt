package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.softteco.nmisko.data.remote.api.RemoteApi
import by.softteco.nmisko.data.entity.post.Post
import by.softteco.nmisko.data.entity.post.PostsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    lateinit var postsList : List<Post>


}