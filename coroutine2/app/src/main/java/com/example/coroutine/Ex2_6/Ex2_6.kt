package com.example.coroutine.Ex2_6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun requestFlow(i:Int) : Flow<String> =flow{
    emit("$i :first")
    delay(500)
    emit("$i: Second")
}

fun main() = runBlocking {
    val startTime =System.currentTimeMillis()
    (1..3).asFlow().onEach { delay(100) }
        .flatMapConcat {
            requestFlow(it)
        }
        .collect{
            value-> println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}