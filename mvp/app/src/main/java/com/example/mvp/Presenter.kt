package com.example.mvp

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Presenter(var viewInterface: ViewInterface) {
    val TAG : String ="로그"
    val model = Model()

    fun clickNumber(i:Int){
        viewInterface.toastMessage(i)

        model.inputPassword(i)
        Log.d(TAG, "MainActivity-clickNumber() called,${model.password.size} ")
        if(model.password.size==4&&model.checkPassword()){
            viewInterface.checkPassword()
        }

    }
}