package by.softteco.nmisko.data.remote


import androidx.annotation.Keep
import by.softteco.nmisko.data.model.post.PostItem

@Keep
class PostResponse(val posts : List<PostItem>)