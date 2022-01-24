package by.softteco.nmisko.data


import by.softteco.nmisko.data.local.user.UserLocal
import by.softteco.nmisko.data.remote.PostResponse
import by.softteco.nmisko.data.remote.model.post.PostItem
import by.softteco.nmisko.data.remote.model.user.UserItem
import by.softteco.nmisko.domain.model.Geo
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.domain.model.User

fun PostResponse.mapToDomainModel(): ArrayList<Post> {
    val newPostList = ArrayList<Post>()
    for (post in this) {
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

fun PostItem.mapToDomainModel() = Post(
    id = this.id,
    body = this.body,
    title = this.title,
    userId = this.userId
)


fun UserItem.mapToDomainModel(): User {
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

fun User.mapToRoomModel(): UserLocal {
    return UserLocal(
        email = this.email,
        id = this.id,
        name = this.name,
        phone = this.name,
        username = this.username,
        website = this.website,
        geoLat = this.geo.lat,
        geoLng = this.geo.lng
    )
}