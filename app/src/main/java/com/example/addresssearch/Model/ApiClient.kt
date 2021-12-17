package com.example.addresssearch.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("autocomplete?queryString=airtel")
    suspend fun getAddress(@Query("city")City : String) : ResponseModel
}