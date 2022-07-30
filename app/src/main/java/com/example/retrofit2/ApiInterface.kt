package com.example.retrofit2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("b/request56_api.php?id=7000")
    suspend fun getAllUsers(): Response<ResponseListUsers>
}