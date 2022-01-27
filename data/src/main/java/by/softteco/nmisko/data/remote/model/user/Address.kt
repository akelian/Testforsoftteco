package by.softteco.nmisko.data.remote.model.user

import com.google.gson.annotations.SerializedName

data class AddressItem(
    @SerializedName("street")
    val street : String,
    @SerializedName("geo")
    val geo: GeoItem
)
