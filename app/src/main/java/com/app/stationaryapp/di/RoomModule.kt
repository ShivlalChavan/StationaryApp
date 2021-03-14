package com.app.stationaryapp.di

import android.content.Context
import androidx.room.Room
import com.app.stationaryapp.room.StationaryDatabase
import com.app.stationaryapp.room.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideStationaryDb(@ApplicationContext context: Context): StationaryDatabase{
        return Room.databaseBuilder(
            context, StationaryDatabase::class.java,
            StationaryDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providebookDao(stationaryDatabase: StationaryDatabase):BookDao{
        return stationaryDatabase.bookDao()
    }

}