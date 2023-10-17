package com.example.coroutine.Ex3_1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.channels.*
//채널은 일종의 파이프 입니다.
fun main()= runBlocking<Unit> {

    val channel = Channel<Int>()
    launch {
        for (x in 1..10){
            channel.send(x) // suspension pointer
        }
    }

    repeat(10){
        println(channel.receive()) // suspenstion pointer
    }
    println("완료 ")
}