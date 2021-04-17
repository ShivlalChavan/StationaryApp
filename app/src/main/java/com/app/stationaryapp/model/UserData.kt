package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserData (
    @SerializedName("user")
    @Expose
    val user: User

)