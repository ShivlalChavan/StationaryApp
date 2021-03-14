package com.app.stationaryapp.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book")
data class BookEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bookid")
    var bid: Int=0,
    @ColumnInfo(name = "id")
    var bookid:String,
    @ColumnInfo(name = "authorName")
    var authorName: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "createdAt")
    var createdAt: String,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "pages")
    var pages: String="",
    @ColumnInfo(name = "price")
    var price: String,
    @ColumnInfo(name = "ratings")
    var ratings: Double,
    @ColumnInfo(name = "status")
    var status: Boolean,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String="",
    @ColumnInfo(name = "_v")
    var __v: String
)