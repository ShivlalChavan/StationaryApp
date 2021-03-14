package com.app.stationaryapp.di

import com.app.stationaryapp.repository.BookListRepository
import com.app.stationaryapp.retrofit.ApiService
import com.app.stationaryapp.room.BookEntityMapper
import com.app.stationaryapp.room.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

     @Singleton
     @Provides
    fun provideMainRepository(
        bookDao: BookDao,
        apiService: ApiService,
        bookEntityMapper: BookEntityMapper
    ):BookListRepository{
      return BookListRepository(bookDao,apiService,bookEntityMapper)
    }

}