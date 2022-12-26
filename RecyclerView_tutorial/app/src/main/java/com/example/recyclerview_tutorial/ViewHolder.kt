package com.example.recyclerview_tutorial

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_tutorial.databinding.LayoutRecyclerItemBinding

class ViewHolder(val binding: LayoutRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(myModel: MyModel){
        binding.myName.text = myModel.name
        myModel.img?.let {
            binding.myImg.setImageResource(myModel.img!!)
        }
    }


}