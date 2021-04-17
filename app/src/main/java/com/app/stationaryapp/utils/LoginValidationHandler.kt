package com.app.stationaryapp.utils

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.view.View
import com.app.stationaryapp.databinding.ActivityLoginLayoutBinding

class LoginValidationHandler
  constructor(val context:Context, val loginLayoutBinding : ActivityLoginLayoutBinding)
{

    public fun emailValidator(editable:Editable){
        if(TextUtils.isEmpty(editable.toString())){
            Utils.showSnackBar(context as View ,"Please enter username")
        }
        else if (!TextUtils.isEmpty(editable.toString()) &&
            !Utils.isEmailValid(editable.toString())){
            Utils.showSnackBar(context as View ,"Please enter valid emailId")
        }
    }


}