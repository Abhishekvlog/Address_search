package com.example.addresssearch.Model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("requestId")
    val requestId: String
)