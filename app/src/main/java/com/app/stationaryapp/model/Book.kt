package com.app.stationaryapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Book(
    @SerializedName("__v")
    @Expose
    var __v: String,
    @SerializedName("id")
    @Expose
    var bookid: String,
    @SerializedName("authorName")
    @Expose
    var authorName: String,
    @SerializedName("category")
    @Expose
    var category: String,
    @SerializedName("createdAt")
    @Expose
    var createdAt: String,
    @SerializedName("image")
    @Expose
    var image: String,
    @SerializedName("pages")
    @Expose
    var pages: String="",
    @SerializedName("price")
    @Expose
    var price: String,
    @SerializedName("ratings")
    @Expose
    var ratings: Double,
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("description")
    @Expose
    var description: String="",
    @SerializedName("bid")
    @Expose
    var bid: String

)