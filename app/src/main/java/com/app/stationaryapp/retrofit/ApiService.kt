package com.app.stationaryapp.retrofit

import com.app.stationaryapp.model.BookBase
import retrofit2.http.GET

interface ApiService {

    @GET("book")
    suspend fun getBooksList(): BookBase
}