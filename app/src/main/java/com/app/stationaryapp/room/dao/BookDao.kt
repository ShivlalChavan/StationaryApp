package com.app.stationaryapp.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.stationaryapp.room.entity.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(bookEntity: BookEntity): Long

    @Query("SELECT * FROM  book ")
    suspend fun getBooks(): List<BookEntity>

}