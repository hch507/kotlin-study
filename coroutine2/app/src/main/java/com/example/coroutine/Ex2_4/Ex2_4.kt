package com.example.coroutine.Ex2_4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

///buffer를 통해 보내는 측이 더 이상 기다리지 않게 합니다.

fun simple(): Flow<Int> = flow{
    for(i in 1..10){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().buffer()
            .collect{
                value->
                delay(300L)
                println(value)
            }
    }
    println("Collected in $time ms")
}