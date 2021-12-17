package com.example.addresssearch.Model


import android.os.Parcelable
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    @SerializedName("addressString")
    val addressString: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("pinCode")
    val pinCode: String,
    @SerializedName("priority")
    val priority: Int,
    @SerializedName("source")
    val source: String
): SearchSuggestion,Parcelable {
    override fun getBody(): String {
        return addressString
    }
}