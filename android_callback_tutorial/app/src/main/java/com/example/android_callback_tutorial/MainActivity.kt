package com.example.android_callback_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG : String ="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        Log.d(TAG, "MainActivity-onCreate() called")

        someCallbackMethod(completion={
            Log.d(TAG, "MainActivity-completion block called/$it")
            someCallbackMethod_1{}
        })
    }

    fun someCallbackMethod(completion :(String)-> Unit){
        Log.d(TAG, "MainActivity-someCallbackMethod() called")
        Handler().postDelayed({
            completion("edn")
        },3000)
    }
    fun someCallbackMethod_1(completion :(String)-> Unit){
        Log.d(TAG, "MainActivity-someCallbackMethod_1() called")
        Handler().postDelayed({
            completion("edn")
        },3000)
    }
}