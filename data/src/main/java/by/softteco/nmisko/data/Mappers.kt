package by.softteco.nmisko.data


import by.softteco.nmisko.data.model.user.UserItem
import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.domain.model.Geo
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User

fun PostResponse.map(): ArrayList<Post> {
    val newPostList = ArrayList<Post>()
    for (post in posts) {
        newPostList.add(
            Post(
                id = post.id,
                body = post.body,
                title = post.title,
                userId = post.userId
            )
        )
    }
    return newPostList
}

fun UserItem.map(): User {
    return User(
        email = email,
        id = id,
        name = name,
        phone = phone,
        username = username,
        website = website,
        geo = Geo(geo.lat, geo.lng)
    )
}