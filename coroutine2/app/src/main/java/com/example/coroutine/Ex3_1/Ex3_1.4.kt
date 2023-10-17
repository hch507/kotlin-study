package com.example.coroutine.Ex3_1

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
// 생성자와 소비자 는 굉장히 일반적인 패턴입니다. 채널을 이용해서 한쪽에서 데이터를 만들고 다른쪽에서 받는 것을 도와주는 확장 함수들입니다.
//1. produce 코루틴을 만들고 채널을 제공합니다.
//2. consumeEach채널에서 반복해서 데이터를 받아값니다.
fun main () = runBlocking<Unit>{
    val oneToTen = produce{
        for( x in 1..10){
            channel.send(x)
        }
    }
    oneToTen.consumeEach {
        println(it)

    }
    println("완료")
}