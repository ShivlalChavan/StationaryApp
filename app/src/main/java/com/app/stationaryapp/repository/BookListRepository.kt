package com.app.stationaryapp.repository

import com.app.stationaryapp.model.Book
import com.app.stationaryapp.model.BookBase
import com.app.stationaryapp.retrofit.ApiService
import com.app.stationaryapp.room.BookEntityMapper
import com.app.stationaryapp.room.dao.BookDao
import com.app.stationaryapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookListRepository
@Inject
constructor(
   private val bookDao: BookDao,
   private val apiService: ApiService,
   private val bookEntityMapper: BookEntityMapper

) {


    suspend fun getBook(): Flow<DataState<List<Book>>> = flow {
        emit(DataState.Loading)
        delay(2000)
        try {
            val  bookBase:BookBase = apiService.getBooksList()


            val bookData = bookBase.data.bookData
            for(book in bookData){
                bookDao.insertBook(bookEntityMapper.mapToEntity(book))
            }
            var cacheBook = bookDao.getBooks()
            emit(DataState.Success(bookEntityMapper.mapFromEntityList(cacheBook)))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }

}