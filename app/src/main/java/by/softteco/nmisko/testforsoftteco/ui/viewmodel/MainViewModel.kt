package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import by.softteco.nmisko.core.data.entity.post.Post
import by.softteco.nmisko.core.data.remote.api.RemoteApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainViewModel : ViewModel() {
    lateinit var postsList : List<Post>

    fun fetchPostsList(remoteApi: RemoteApi){
        CoroutineScope(Dispatchers.IO).launch {

        }
    }
}