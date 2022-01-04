package by.softteco.nmisko.testforsoftteco.ui.viewmodel

import androidx.lifecycle.ViewModel
import by.softteco.nmisko.data.remote.model.post.PostItem


class MainViewModel : ViewModel() {
    lateinit var postsList : List<PostItem>


}