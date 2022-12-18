package com.example.jetpack_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.jetpack_nav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG : String ="로그"
    private lateinit var mbinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity-onCreate() called")
        mbinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mbinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment
       //컨트롤러 설정
        val navController = navHostFragment.navController
        //컨드롤러와 bottomnav랑 연결
        NavigationUI.setupWithNavController(mbinding.MyBottomNav,navController)
    }
}