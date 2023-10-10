package com.example.coroutine.Ex2_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
/////////drop
suspend fun someCalc3(i:Int):Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..10).asFlow().transform {
        emit(it)
        emit(someCalc3(it))
    }.drop(3).collect{
        println(it)
    }
}