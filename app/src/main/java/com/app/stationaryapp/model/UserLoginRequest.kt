package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class UserLoginRequest  (
    @SerializedName("email")
    @Expose
    var email:String?="",
    @SerializedName("password")
    @Expose
    var password:String?=""
){

    val isInValid :Boolean
      get() = email.isNullOrEmpty() || password.isNullOrEmpty()


}