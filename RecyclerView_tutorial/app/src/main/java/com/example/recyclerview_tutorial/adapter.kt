package com.example.recyclerview_tutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_tutorial.databinding.LayoutRecyclerItemBinding

class adapter() :RecyclerView.Adapter<ViewHolder>() {

    private var modellist = ArrayList<MyModel>()
    //뷰홀더가 생성되었을떄
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =LayoutRecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    //븅하 뷰홀더가 묶었을때
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(this.modellist[position])
    }
    //아이템 수
   override fun getItemCount(): Int {
        return this.modellist.size
    }

    fun submit(modellist : ArrayList<MyModel>){
        this.modellist=modellist
    }
}