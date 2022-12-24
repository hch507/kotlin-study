package com.example.recyclerview_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.recyclerview_tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var mydelList = ArrayList<MyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val mbinding : ActivityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        for(i in 1..10){
            var mymodel = MyModel("사원 $i",img = R.drawable.ic_baseline_people_24)

            mydelList.add(mymodel)
        }
    }
}