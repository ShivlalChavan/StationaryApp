package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserBase(
    @SerializedName("data")
    @Expose
    val data: UserData,
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("token")
    @Expose
    val token: String
)