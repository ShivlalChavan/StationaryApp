package com.app.stationaryapp.ui.activity.login

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.app.stationaryapp.BaseActivity
import com.app.stationaryapp.databinding.ActivityLoginLayoutBinding
import com.app.stationaryapp.utils.DataState
import com.app.stationaryapp.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginActivity : BaseActivity() , View.OnClickListener {

    private lateinit var binding : ActivityLoginLayoutBinding
    private val loginViewModel : LoginViewModel by viewModels()


    override fun initViewBinding() {
        binding = ActivityLoginLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        observeViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initListener()

    }

    private fun initListener() {
        binding.signInBtn.setOnClickListener(this)
    }


    override fun observeViewModel() {
       loginViewModel.userData.observe(this, Observer { dataState->
            when(dataState){
                is DataState.Success ->{
                    Timber.e("LoginSuccess")
                    Timber.e("LoginActivity ${dataState.data.user}")
                }

                is DataState.Error->{
                    Timber.e("LoginSuccess ${dataState.exception}]")
                    Utils.showSnackBar(binding.content,dataState.exception.message.toString())
                }

                is DataState.Loading->{
                    Timber.e("Loading")
                }
            }
       })
    }

    override fun onClick(v: View?) {
       when(v){
           binding.signInBtn ->{

               loginViewModel.signInUser("kunal@gmail.com","12345678",UserStateEvent.GetUserEvent)
           }
       }
    }


}