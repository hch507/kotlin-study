package com.example.coroutine.Ex1_6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun printRandom(){
    delay(500L)
    println(Random.nextInt(0,500))
}
fun main() {
    val job = GlobalScope.launch(Dispatchers.IO) {
            println(coroutineContext)
            printRandom()
    }
    Thread.sleep(1000L)
}