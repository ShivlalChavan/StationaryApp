package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("__v")
    @Expose
    val __v: String,
    @SerializedName("_id")
    @Expose
    val _id: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("mobile")
    @Expose
    val mobile: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("role")
    @Expose
    val role: String
)