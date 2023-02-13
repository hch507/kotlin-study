package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding
//view - viewmdel의 데이터를 관찰하고 변경
//viewmodel - 데이타를 저장하고 model과 커뮤니케이션하는 로직 작성
//model 은 데이터를 처리하는 로직
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    val viewmodel = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.number=viewmodel
        //viewmodel을 관찰하고 view를 변경
        viewmodel.toastMessage.observe(this, Observer {
            Toast.makeText(this,"${it}을 큰릭하였습니다", Toast.LENGTH_SHORT).show()
        })

        viewmodel.checkPassword.observe(this, Observer{
            if(viewmodel.checkPassword.value==true)
                binding.message.visibility= View.VISIBLE
            else
                Toast.makeText(this,"암호가 틀렷습니다", Toast.LENGTH_SHORT).show()
        })
    }
}