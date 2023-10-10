package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking{
    launch { doOneTwoThree() }
}


suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000)
        println("3!")
    }
    job.join()
    launch(Dispatchers.IO) {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    println("runBlocking : ${Thread.currentThread().name}")

    println("2!")
    suspend fun doOne() {
        println("launch1: ${Thread.currentThread().name}")
        println("1!")
    }

    suspend fun doTwo() {
        println("launch1: ${Thread.currentThread().name}")
        println("2!")

    }
}



//
//fun main(): Unit = runBlocking{
//    doOneTwoThree()
//    println("5")
//}
//
//
//suspend fun doOneTwoThree() = coroutineScope {
//    val job1 = launch {
//        println("launch1: ${Thread.currentThread().name}")
//        delay(1000L)
//        println("3!")
//    }
//
//    val job2 =launch {
//        println("launch2: ${Thread.currentThread().name}")
//        println("1!")
//    }
//    val job3 =launch{
//        println("launch3 : ${Thread.currentThread().name}")
//        delay(500L)
//        println("2!")
//    }
//
//    delay(800L)
//    job1.cancel()
//    job2.cancel()
//    job3.cancel()
//    println("4")
//}