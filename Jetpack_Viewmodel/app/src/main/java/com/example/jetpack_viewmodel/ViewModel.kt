package com.example.jetpack_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType {
    PlUS,
    MINUS
}
//데어터의 변경사항을 알려주는  livedata를 가지고 있다
class ViewModel : ViewModel(){

    val TAG : String ="로그"
    private  val _data = MutableLiveData<Int>()

    //내부의 livedata호출시 사용
    val data :LiveData<Int>
        get() = _data


    init{
        Log.d(TAG, "ViewModel-() called- 생성자를 초기화")
        _data.value = 0
    }

    fun changeValue(actiontype : ActionType, input:Int){
        when(actiontype){
            ActionType.PlUS ->
                _data.value = _data.value?.plus(input)

            ActionType.MINUS->
                _data.value = _data.value?.minus(input)
        }

    }



}