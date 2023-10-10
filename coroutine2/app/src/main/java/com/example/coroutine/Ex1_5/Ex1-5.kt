package com.example.coroutine.Ex1_5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() :Unit = runBlocking {
    launch {
        println("부모의 콘텍스트/ ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("부모의 콘텍스트/ ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) {
        println("부모의 콘텍스트/ ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("부모의 콘텍스트/ ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("Fast Campus")) {
        println("부모의 콘텍스트/ ${Thread.currentThread().name}")
    }
}
