package by.softteco.nmisko.core.data.entity.post


import androidx.annotation.Keep
import by.softteco.nmisko.core.data.entity.post.Post

@Keep
data class PostsResponse(
    val posts: ArrayList<Post>
)