package com.example.mvvm

import android.util.Log
//모델 - 데이터를 처리하하는 로직
class Model {
    var password : MutableList<Int> = mutableListOf()
    val TAG : String ="로그"

    //데이터 입력
    fun inputPassword(i :Int){
        if(password.size<4) {
            password.add(i)
            Log.d(TAG, "model-inputPassword() called ${password.size}")
        }
    }

    //비밀번호 검사
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