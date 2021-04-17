package com.app.stationaryapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

object Utils {

     val BASEURL:String = "http://192.168.15.207:3000/api/v1/"
     val IMAGE_BASEURL = "http://192.168.15.207:3000/"

    fun showSnackBar(view: View, message:String){
        val snack = Snackbar.make(view,message,Snackbar.LENGTH_SHORT)
        snack.show()
    }

    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}