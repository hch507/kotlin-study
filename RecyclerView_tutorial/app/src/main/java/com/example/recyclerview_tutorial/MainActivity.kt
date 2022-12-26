package com.example.recyclerview_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var modelList = ArrayList<MyModel>()
    lateinit var madapter: adapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val mbinding : ActivityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)


        for(i in 1..10){
            var mymodel = MyModel("사원 $i",img = R.drawable.ic_baseline_people_24)

            modelList.add(mymodel)
        }
        madapter = adapter()
        madapter.submit(modelList)


        mbinding.myRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        mbinding.myRecyclerView.adapter=madapter
        mbinding.myRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }
}