package by.softteco.nmisko.domain.model



data class User(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    val geo: Geo
)