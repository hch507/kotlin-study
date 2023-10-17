package com.example.coroutine.Ex3_1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//채널이 더이상 보낼 자료가 없으면 close 매서드를 이용해 채널을 닫을 수있습니다
fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()

    launch{
        for( x in 1..10){
            channel.send(x)
        }
        channel.close()
    }

    for(x in channel){
        println(x)
    }
    println("완료")
}