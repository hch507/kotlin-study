package com.example.coroutine.Ex2_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
////////////dropWhile
suspend fun someCalc4(i:Int):Int{
    delay(100L)
    return i*2
}

fun main() = runBlocking {
    (1..10).asFlow().transform {
        emit(it)
        emit(someCalc4(it))
    }.dropWhile {
        it<5
    }.collect{
        println(it)
    }
}