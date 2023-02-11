package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvp.databinding.ActivityMainBinding
///
///
///
///
/// mvp : presenter가 view와 model을 제어하고 인터페이스(activity가 둘러쌈)
class MainActivity : AppCompatActivity(),ViewInterface{
    lateinit var binding:ActivityMainBinding

    var presenter=Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.number=this
    }

    fun clickNumber(i:Int){

        presenter.clickNumber(i)
    }

    override fun toastMessage(i:Int) {
        Toast.makeText(this,"${i}을 큰릭하였습니다", Toast.LENGTH_SHORT).show()
    }

    override fun checkPassword() {
        binding.message.visibility= View.VISIBLE
    }
}