package com.app.stationaryapp.ui

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.repository.BookListRepository
import com.app.stationaryapp.utils.DataState
import com.app.stationaryapp.utils.exhaustive
import com.google.gson.Gson
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class BookListViewModel
 @ViewModelInject
 constructor(
     private val bookListRepository: BookListRepository,
     @Assisted private val savedState: SavedStateHandle
 ):ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Book>>> = MutableLiveData()
    private val bookeDetail= MutableLiveData<Book>()

   val dataState: LiveData<DataState<List<Book>>>
     get() = _dataState


    fun setBookStateEvent(bookStateEvent:BookStateEvent){
        viewModelScope.launch{
           when(bookStateEvent){
             is BookStateEvent.GetBooksEvent ->{
                bookListRepository.getBook()
                    .onEach {dataState->
                        _dataState.value = dataState

                        var gson = Gson()
                        Log.e("BookList","Data"+gson.toJson(_dataState.value))
                    }
                    .launchIn(viewModelScope)
             }

             is BookStateEvent.None->{

             }
           }.exhaustive
        }
    }

    fun onBookDetail(bookItem:Book){
        bookeDetail.value = bookItem
    }

}


sealed class BookStateEvent{
  object GetBooksEvent:BookStateEvent()
  object  None: BookStateEvent()

}