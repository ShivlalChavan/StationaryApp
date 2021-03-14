package com.app.stationaryapp.repository

import android.util.Log
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.model.BookBase
import com.app.stationaryapp.retrofit.ApiService
import com.app.stationaryapp.room.BookEntityMapper
import com.app.stationaryapp.room.dao.BookDao
import com.app.stationaryapp.utils.DataState
import com.google.gson.Gson
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

   /*suspend fun getBook(): Flow<DataState<List<Book>>> = flow {
       emit(DataState.Loading)
       delay(2000)
       try {
           val  bookBase = apiService.getBooksList()
           var gson= Gson()
           Log.e("BookList","Data"+gson.toJson(bookBase))
           //var bookData: BookBase = networkBookData
           for(book in bookBase.data.bookData){
              bookDao.insertBook(bookEntityMapper.mapToEntity(book))
           }
           val cacheBook = bookDao.getBooks()
           emit(DataState.Success(bookEntityMapper.mapFromEntityList(cacheBook)))
       }catch (e:Exception){
         emit(DataState.Error(e))
       }
   }*/

    suspend fun getBook(): Flow<DataState<List<Book>>> = flow {
        emit(DataState.Loading)
        delay(2000)
        try {
            val  bookBase:BookBase = apiService.getBooksList()
            var gson = Gson()
            Log.e("BookList","Data"+gson.toJson(bookBase.data.bookData))
            //var bookData: BookBase = networkBookData
            val bookData = bookBase.data.bookData
            for(book in bookData){
                bookDao.insertBook(bookEntityMapper.mapToEntity(book))
            }
            var cacheBook = bookDao.getBooks()
            Log.e("BookList","DataBase"+gson.toJson(cacheBook))
            emit(DataState.Success(bookEntityMapper.mapFromEntityList(cacheBook)))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }

}