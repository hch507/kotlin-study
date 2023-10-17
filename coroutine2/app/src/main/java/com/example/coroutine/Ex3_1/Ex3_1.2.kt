package com.example.coroutine.Ex3_1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Channel의 send()와 receive()는 서로의존적이기 떄문에 같은 코루틴에서 사용하면 안됨
fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()

    launch{
        for (x in 1..10){
            channel.send(x)
        }
        repeat(10){
            println(channel.receive())
        }
        println("완료")
    }
}