package com.example.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException
import kotlin.random.Random
import kotlin.system.measureTimeMillis

//suspend fun getRandom() :Int{
//    delay(1000L)
//    return Random.nextInt(0, 500)
//}
//suspend fun getRandom2() :Int{
//    delay(1000L)
//    return Random.nextInt(0, 500)
//}
//
//fun main() = runBlocking {
//    val elapsedTime = measureTimeMillis {
//        val value1 = getRandom()
//        val value2 = getRandom2()
//        print("${value1}+${value2}=${value1+value2}")
//    }
//    print(elapsedTime)
//}
