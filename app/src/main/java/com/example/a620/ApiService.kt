package com.example.a620

import com.example.a620.Dao.BaikeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/baiketiku/index")
    suspend fun getBaikeTiKu( @Query("key") apiKey: String): BaikeResponse
}