package com.example.jetpack_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG : String ="로그"

    lateinit var myviewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            Log.d(TAG, "MainActivity-onCreate() called")
            //뷰모델 가져오기
            myviewModel= ViewModelProvider(this).get(ViewModel::class.java)
            //변경되는  livedata 관찰
            myviewModel.data.observe(this, Observer {
                text_value.text = it.toString()
            })

        plus_button.setOnClickListener(View.OnClickListener {
            val userinput = editText.text.toString().toInt()
            myviewModel.changeValue(ActionType.PlUS,userinput)
        })

        minus_button.setOnClickListener(View.OnClickListener {
            val userinput = editText.text.toString().toInt()
            myviewModel.changeValue(ActionType.MINUS,userinput)
        })

    }
}