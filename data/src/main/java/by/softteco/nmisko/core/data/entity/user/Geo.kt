package by.softteco.nmisko.core.data.entity.user


import com.google.gson.annotations.SerializedName

data class Geo(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)