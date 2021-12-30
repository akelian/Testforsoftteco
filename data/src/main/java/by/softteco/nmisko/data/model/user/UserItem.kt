package by.softteco.nmisko.data.model.user


import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("geo")
    val geo: Geo
)