package com.example.coroutine.Ex1_3

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//취소가 안되고 수행되어야할 경우 withContext(NonCancellable)
suspend private fun doOneTwoThree() = coroutineScope{
    val job1 =launch {
        try {
            println("${Thread.currentThread().name}")
            delay(1000L)
            println("3")
        }finally {
            println("jpbis finishing!")
            //파일을 닫는 코드
        }
    }
    val job2 =launch {
        withContext(NonCancellable){
            println("${Thread.currentThread().name}")
            delay(1000L)
            println("2")
        }

    }
    delay(800L)
    job1.cancel()
    job2.cancel()
    println("4")
}
fun main() = runBlocking {
    doOneTwoThree()

}
