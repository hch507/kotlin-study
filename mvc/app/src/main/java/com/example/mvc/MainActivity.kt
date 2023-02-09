package com.example.mvc




///
///
///  mvc 에서 controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val model = model()
    val TAG : String ="로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.number=this

    }

    fun clickNumber(i:Int){
        Toast.makeText(this,"${i}을 큰릭하였습니다", Toast.LENGTH_SHORT).show()

        model.inputPassword(i)
        Log.d(TAG, "MainActivity-clickNumber() called,${model.password.size} ")
        if(model.password.size==4&&model.checkPassword()){
            binding.message.visibility= View.VISIBLE
        }

    }
}