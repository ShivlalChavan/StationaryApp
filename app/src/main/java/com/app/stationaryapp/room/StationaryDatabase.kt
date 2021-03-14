package com.app.stationaryapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.stationaryapp.room.dao.BookDao
import com.app.stationaryapp.room.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1,exportSchema = false)
abstract class StationaryDatabase:RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object{
        val DATABASE_NAME:String = "stationary_db"
    }

}