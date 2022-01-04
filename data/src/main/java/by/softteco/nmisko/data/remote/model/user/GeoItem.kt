package by.softteco.nmisko.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class GeoItem(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)