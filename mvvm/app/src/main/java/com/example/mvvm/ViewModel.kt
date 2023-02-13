package com.example.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
//viewmodel 데이터를 저장하고 model과 커뮤니케이션함
class ViewModel {
    val TAG : String ="로그"
    var toastMessage = MutableLiveData<Int>()
    var checkPassword = MutableLiveData<Boolean>()

    val model = Model()
    fun clickNumber(i:Int){
        toastMessage.value =i
        model.inputPassword(i)
        Log.d(TAG, "MainActivity-clickNumber() called,${model.password.size} ")
        if(model.password.size==4&&model.checkPassword()){
            checkPassword.value =true
        }

    }
}