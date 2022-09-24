package com.example.hilt_retrofit_mvvm_ld.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInstance {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>
}