package com.example.coroutine.Ex1_3

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

//일정 시간후 취소되길 바란다면 withTimeOut
suspend private fun doOneTwoThree() = coroutineScope{
    val job1 =launch {
        println("${Thread.currentThread().name}")
        delay(300L)
        println("3")
        println("jpbis finishing!")
            //파일을 닫는 코드

    }
    val job2 =launch {
        println("${Thread.currentThread().name}")
        delay(1000L)
        println("2")
        println("jpbis finishing!")

    }

    println("4")
}
fun main() = runBlocking {
    withTimeout(500L){
        doOneTwoThree()

    }

}