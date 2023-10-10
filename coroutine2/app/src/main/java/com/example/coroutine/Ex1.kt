package com.example.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking {
//    launch{
//        println("launch1: ${Thread.currentThread().name}")
//        println("world")
//    }
//    println("runBlocking: ${Thread.currentThread().name}")
//    println("hello")
//}
//////////////////delay함수
//fun main() = runBlocking {
//    launch{
//        println("launch1: ${Thread.currentThread().name}")
//        println("world")
//    }
//    println("runBlocking: ${Thread.currentThread().name}")
//    delay(500L)
//    println("hello")
//}

//fun main() = runBlocking {
//    launch{
//        println("launch1: ${Thread.currentThread().name}")
//        println("world")
//    }
//    println("runBlocking: ${Thread.currentThread().name}")
//    Thread.sleep(500)
//    println("hello")
//}
//////////////////launch 여러개
//fun main() = runBlocking {
//    launch{
//        println("launch1: ${Thread.currentThread().name}")
//        println("3")
//    }
//    launch{
//        println("launch2: ${Thread.currentThread().name}")
//        println("1")
//    }
//
//    println("runBlocking: ${Thread.currentThread().name}")
//    Thread.sleep(500)
//    println("3")
//}