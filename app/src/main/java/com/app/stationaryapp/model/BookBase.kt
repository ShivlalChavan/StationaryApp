package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookBase(
    @SerializedName("data")
    @Expose
    var data: Data,
    @SerializedName("results")
    @Expose
    var results: Int,
    @SerializedName("status")
    @Expose
    var status: String
)