package com.app.stationaryapp.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.repository.BookListRepository
import com.app.stationaryapp.utils.DataState
import com.app.stationaryapp.utils.exhaustive
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

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
                    }
                    .launchIn(viewModelScope)
             }
             is BookStateEvent.None->{}
           }.exhaustive
        }
    }

    fun onBookDetail(bookItem:Book){
        bookeDetail.value = bookItem
        Timber.e("Book Detail ${bookeDetail.value}")

    }




}


sealed class BookStateEvent{
  object GetBooksEvent:BookStateEvent()
  object  None: BookStateEvent()

}