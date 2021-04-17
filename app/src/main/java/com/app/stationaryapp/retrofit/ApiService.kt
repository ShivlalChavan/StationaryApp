package com.app.stationaryapp.retrofit

import com.app.stationaryapp.model.BookBase
import com.app.stationaryapp.model.UserBase
import com.app.stationaryapp.model.UserLoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("book")
    suspend fun getBooksList(): BookBase

    @POST("users/login")
    suspend fun signInUser(@Body userLogin: UserLoginRequest): UserBase
}