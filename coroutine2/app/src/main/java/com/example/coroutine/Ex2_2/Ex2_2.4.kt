package com.example.coroutine.Ex2_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
/////////take
suspend fun someCalc1(i:Int):Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..10).asFlow().transform {
        emit(it)
        emit(someCalc1(it))
    }.take(5).collect{
        println(it)
    }
}