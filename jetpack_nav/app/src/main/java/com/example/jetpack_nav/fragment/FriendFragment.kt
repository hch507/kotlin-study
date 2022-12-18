package com.example.jetpack_nav.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jetpack_nav.databinding.FragmentFriendBinding
import com.example.jetpack_nav.databinding.FragmentHomeBinding

class FriendFragment : Fragment()  {

    private  var mBinding : FragmentFriendBinding? = null

    //view가 생성이 될떄
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFriendBinding.inflate(inflater, container, false)

        mBinding=binding
        return mBinding?.root
    }

    override fun onDestroy() {
        mBinding=null
        super.onDestroy()
    }
}