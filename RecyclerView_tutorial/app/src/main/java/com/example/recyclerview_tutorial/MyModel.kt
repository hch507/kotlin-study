package com.example.recyclerview_tutorial

import android.util.Log

class MyModel(var name : String? =null, var img : Int?  ){
    val TAG : String ="로그"

    init{
        Log.d(TAG, "MyModel-() called")
    }

}
