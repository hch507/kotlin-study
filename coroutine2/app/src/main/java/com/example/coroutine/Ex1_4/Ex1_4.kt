package com.example.coroutine.Ex1_4

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//순차차적으로 sunpend함수를 수행시켜보자
suspend private fun getRandom() :Int{
    delay(1000L)
    return 13
}
suspend private fun getRandom2() :Int{
    delay(1000L)
    return 29
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = getRandom()
        val value2 = getRandom2()


        println("${value1}+${value2}=${value1+value2}")
    }
    print(elapsedTime)
}