package com.example.mvc
///
///
//////
//////    mvc에서 model

import android.util.Log

class model {
    var password : MutableList<Int> = mutableListOf()
    val TAG : String ="로그"
    fun inputPassword(i :Int){
        if(password.size<4) {
            password.add(i)
            Log.d(TAG, "model-inputPassword() called ${password.size}")
        }
    }
    fun checkPassword():Boolean{
        var truecount =0
        val savePassword = mutableListOf(1,2,3,4)
        for(i in 0 until password.size) {
            if (password.get(i)==savePassword.get(i)) {
                truecount++
            }
        }

        return truecount==4
    }
}