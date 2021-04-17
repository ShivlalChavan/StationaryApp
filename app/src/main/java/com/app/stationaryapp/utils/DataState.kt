package com.app.stationaryapp.utils

sealed class DataState<out R> {

    data class Success<out T>(val data:T):DataState<T>()
    data class Error(val exception: Exception): DataState<Nothing>()
    object Loading: DataState<Nothing>()

    override fun toString(): String {
        return when(this){
            is Success<*> -> "Success[data=$data]"
            is Error -> "error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}
val DataState<*>.succeeded
    get() = this is DataState.Success && data != null