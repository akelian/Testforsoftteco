package by.softteco.nmisko.data.entity.post


import androidx.annotation.Keep

@Keep
data class PostsResponse(
    val posts: ArrayList<Post>
)