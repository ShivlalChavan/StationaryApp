package com.app.stationaryapp.ui.activity.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.stationaryapp.model.UserData
import com.app.stationaryapp.model.UserLoginRequest
import com.app.stationaryapp.repository.LoginRepository
import com.app.stationaryapp.utils.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel
@ViewModelInject
@Inject
 constructor(
    private val loginRepository: LoginRepository
) :ViewModel() {


    private var _user = MutableLiveData<DataState<UserLoginRequest>>()
    val user = _user as LiveData<DataState<UserLoginRequest>>

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _userData: MutableLiveData<DataState<UserData>> = MutableLiveData()
     val userData : LiveData<DataState<UserData>>
        get() = _userData

    fun signInUser(userName:String, password:String, userState:UserStateEvent){

        if(!UserLoginRequest( email = userName).isInValid){
          _user.value = DataState.Error(Exception("Please enter email Id"))
        }
        else if(!UserLoginRequest( password = password).isInValid)
        {
            _user.value = DataState.Error(Exception("Please enter password"))
        }
        else{
            loginUser(UserLoginRequest(email = userName,password = password),userState)
        }
    }

    private fun loginUser(userLoginRequest: UserLoginRequest,userState:UserStateEvent) {
        viewModelScope.launch {
            when(userState){
                is UserStateEvent.GetUserEvent -> {
                    loginRepository.userSignIn(userLoginRequest).collect { user ->
                        user.let {
                            Timber.e("UserLoginModel ${it}")
                            _userData.value = user

                        }
                    }
                }
                is UserStateEvent.None ->{}
            }
        }
    }
}

sealed class UserStateEvent{
    object GetUserEvent:UserStateEvent()
    object  None:UserStateEvent()


}