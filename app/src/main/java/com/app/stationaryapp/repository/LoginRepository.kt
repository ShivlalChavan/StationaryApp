package com.app.stationaryapp.repository


import com.app.stationaryapp.model.UserData
import com.app.stationaryapp.model.UserLoginRequest
import com.app.stationaryapp.retrofit.ApiService
import com.app.stationaryapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

 class LoginRepository
@Inject
 constructor(
    val apiService: ApiService
){

    suspend fun userSignIn(userLoginRequest: UserLoginRequest) : Flow<DataState<UserData>> = flow {
          emit(DataState.Loading)
        delay(3000)
        try {
            val user = apiService.signInUser(userLoginRequest)
            Timber.e("FLOw ${user}")

            emit(DataState.Success(user.data))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }


    }

}